package org.openl.rules.datatype.gen.bean.writers;

import java.util.Date;
import java.util.Map;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.openl.rules.datatype.gen.FieldDescription;
import org.openl.util.ClassUtils;

/**
 * Writes getters to the generated bean class.
 * 
 * @author DLiauchuk
 */
public class GettersWriter extends MethodWriter {

    /**
     * 
     * @param beanNameWithPackage name of the class being generated with package, symbol '/' is used as separator<br>
     *            (e.g. <code>my/test/TestClass</code>)
     * @param beanFields fields of generating class.
     */
    public GettersWriter(String beanNameWithPackage, Map<String, FieldDescription> beanFields) {
        super(beanNameWithPackage, beanFields);
    }

    public void write(ClassWriter classWriter) {
        /*
         * ignore those fields that are of void type. In java it is impossible but possible in Openl, e.g. spreadsheet
         * cell with void type.
         */
        for (Map.Entry<String, FieldDescription> field : getAllFields().entrySet()) {
            if (validField(field.getKey(), field.getValue())) {
                generateGetter(classWriter, field);
            }
        }
    }

    /**
     * Generates getter for the fieldEntry.
     * 
     * @param classWriter
     * @param fieldEntry
     */
    protected void generateGetter(ClassWriter classWriter, Map.Entry<String, FieldDescription> fieldEntry) {
        MethodVisitor methodVisitor;
        String fieldName = fieldEntry.getKey();
        FieldDescription field = fieldEntry.getValue();
        String getterName = ClassUtils.getter(fieldName);

        final String javaType = field.getTypeDescriptor();
        final String format = "()" + javaType;
        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, getterName, format, null, null);

        AnnotationVisitor av = methodVisitor.visitAnnotation("Ljavax/xml/bind/annotation/XmlElement;", true);
        av.visit("name", fieldName);

        if (!field.hasDefaultValue() && field.getTypeDescriptor().length() != 1) {
            av.visit("nillable", true);
        }
        if (field.hasDefaultValue() && !field.hasDefaultKeyWord()) {
            String defaultFieldValue = field.getDefaultValueAsString();
            if (Boolean.class.getName().equals(field.getTypeName()) || boolean.class.getName()
                .equals(field.getTypeName())) {
                defaultFieldValue = String.valueOf(field.getDefaultValue());
            } else if (field.getTypeName().equals(Date.class.getName())) {
                Date date = (Date) field.getDefaultValue();
                defaultFieldValue = ISO8601DateFormater.format(date);
            }
            av.visit("defaultValue", defaultFieldValue);
        }
        av.visitEnd();

        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitFieldInsn(Opcodes.GETFIELD, getBeanNameWithPackage(), fieldName, javaType);
        String retClass = field.getTypeDescriptor();
        Type type = Type.getType(retClass);
        methodVisitor.visitInsn(type.getOpcode(Opcodes.IRETURN));
        methodVisitor.visitMaxs(0, 0);
    }

}
