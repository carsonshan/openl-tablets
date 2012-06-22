package org.openl.conf.ant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openl.rules.project.ProjectDescriptorManager;
import org.openl.rules.project.model.Module;
import org.openl.rules.project.model.ModuleType;
import org.openl.rules.project.model.PathEntry;
import org.openl.rules.project.model.ProjectDescriptor;

public class JavaInterfaceAntTask extends JavaAntTask {
    
    private final Log log = LogFactory.getLog(JavaInterfaceAntTask.class);
    
    private static final String RULES_XML = "rules.xml";    
    private static final String DEFAULT_CLASSPATH = "./bin";

    private boolean ignoreTestMethods = false;

    protected ProjectDescriptor createNewProject() {
        ProjectDescriptor project = new ProjectDescriptor();      
        project.setId(getDisplayName());
        project.setName(getDisplayName());
        
        List<PathEntry> classpath = new ArrayList<PathEntry>();
        classpath.add(new PathEntry(DEFAULT_CLASSPATH));        
        project.setClasspath(classpath);
        
        return project;
    }

    protected Module createNewModule() {
        Module module = new Module();
        
        module.setName(getDisplayName());
        module.setType(ModuleType.DYNAMIC);
        module.setClassname(getTargetClass());
        module.setRulesRootPath(new PathEntry(getSrcFile()));
        return module;
    }

    @Override
    protected OpenLToJavaGenerator getJavaGenerator() {
        return new JavaInterfaceGenerator.Builder(getOpenClass(), getTargetClass())
        .methodsToGenerate(getMethods()).fieldsToGenerate(getFields()).ignoreNonJavaTypes(isIgnoreNonJavaTypes())
        .ignoreTestMethods(isIgnoreTestMethods()).srcFile(getSrcFile()).deplSrcFile(getDeplSrcFile()).build();
    }

    @Override
    protected void writeSpecific() {
        writeRulesXML();
    }

    protected void writeRulesXML() {
        File rulesDescriptor = new File(RULES_XML);
        ProjectDescriptorManager manager = new ProjectDescriptorManager();

        ProjectDescriptor projectToWrite = null;
        List<Module> modulesToWrite = new ArrayList<Module>();
        long timeSinceModification = System.currentTimeMillis() - rulesDescriptor.lastModified();

        // FIXME: This is tricky to rely on the time since modification.
        // Consider that if the time since last modification is small enough it
        // will be the modification
        // made for previously created module by this ant task and we need to add one more module to the project
        // @author DLiauchuk
        if (rulesDescriptor.exists() && timeSinceModification < 2000) {
            // There is a previously created project descriptor, with modules in it.
            // The time was small enough to consider that it was modified/created by the generator.
            // Add current module to existed project.
            ProjectDescriptor existedDescriptor = null;
            try {
                existedDescriptor = manager.readDescriptor(rulesDescriptor);
                Module newModule = createNewModule();
                for (Module existedModule : existedDescriptor.getModules()) {                    
                    if (!existedModule.getClassname().equals(newModule.getClassname())) {
                        modulesToWrite.add(newModule);
                    }
                    modulesToWrite.add(copyOf(existedModule));
                }
                projectToWrite = existedDescriptor;
            } catch (Exception e) {
                log.error("Error while reading previously created rules.xml", e);
            }
        } else {
            // Create new project and add new module
            projectToWrite = createNewProject();
            modulesToWrite.add(createNewModule());
        }        
        projectToWrite.setModules(modulesToWrite);

        try {
            FileOutputStream fous = new FileOutputStream(rulesDescriptor);
            manager.writeDescriptor(projectToWrite, fous);
        } catch (Exception e) {
            log.error("Error while writing rules.xml", e);
        }
    }
    
    /**
     * Copy the module without {@link Module#getProject()}, as it prevents
     * to Circular dependency.
     * @param module
     * @return copy of income module without project field
     */
    private Module copyOf(Module module) {
        Module copy = new Module();
        copy.setClassname(module.getClassname());
        copy.setName(module.getName());
        copy.setProperties(module.getProperties());
        copy.setRulesRootPath(module.getRulesRootPath());
        copy.setType(module.getType());
        return copy;
    }

    public boolean isIgnoreTestMethods() {
        return ignoreTestMethods;
    }

    public void setIgnoreTestMethods(boolean ignoreTestMethods) {
        this.ignoreTestMethods = ignoreTestMethods;
    }
}
