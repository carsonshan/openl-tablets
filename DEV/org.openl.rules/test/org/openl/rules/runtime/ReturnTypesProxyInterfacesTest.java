package org.openl.rules.runtime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.openl.rules.TestHelper;

public class ReturnTypesProxyInterfacesTest {

    private static final String EXP_MSG = "Return type of method \"%s\" should be %s";

    private File xlsFile;

    @Before
    public void setUp() {
        xlsFile = new File("test/rules/runtime/ReturnTypeValidation.xlsx");
    }

    private <T> T initInstance(Class<T> tClass) {
        TestHelper<T> testHelper = new TestHelper<>(xlsFile, tClass);

        return testHelper.getInstance();
    }

    @Test
    public void testSameReturnType() {
        assertEquals((Long) 1L, initInstance(SameReturnType.class).doSomething("1"));
    }

    @Test
    public void testUpCastReturnType() {
        assertEquals((Number) 1L, initInstance(UpCastReturnType.class).doSomething("1"));
    }

    @Test
    public void testObjectReturnType() {
        assertEquals((Object) 1L, initInstance(ObjectReturnType.class).doSomething("1"));
    }

    @Test
    public void testVoidReturnType() {
        try {
            initInstance(VoidReturnType.class);
        } catch (RuntimeException e) {
            assertReturnTypeException(String.format(EXP_MSG, "doSomething", "java.lang.Long"), e);
            return;
        }
        fail("Must be failed with return type mismatch exception");
    }

    @Test
    public void testArrayReturnType() {
        try {
            initInstance(ArrayReturnType.class);
        } catch (RuntimeException e) {
            assertReturnTypeException(String.format(EXP_MSG, "doSomething", "java.lang.Long"), e);
            return;
        }
        fail("Must be failed with return type mismatch exception");
    }

    @Test
    public void testCannotCastReturnType() {
        try {
            initInstance(CannotCastReturnType.class);
        } catch (RuntimeException e) {
            assertReturnTypeException(String.format(EXP_MSG, "doSomething", "java.lang.Long"), e);
            return;
        }
        fail("Must be failed with return type mismatch exception");
    }

    @Test
    public void testLongArrayReturnType() {
        try {
            initInstance(LongArrayReturnType.class);
        } catch (RuntimeException e) {
            assertReturnTypeException(String.format(EXP_MSG, "doArray", "[J"), e);
            return;
        }
        fail("Must be failed with return type mismatch exception");
    }

    @Test
    public void testPrimitiveLongArrayReturnType() {
        final long[] expected = new long[] {1, 2, 3};
        final long[] actual = initInstance(PrimitiveLongArrayReturnType.class).doArray();
        assertArraysEquals(expected, actual);
    }

    @Test
    public void testVoidReturnTypeToVoid() {
        initInstance(VoidReturnTypeToVoid.class).voidMethod();
    }

    @Test
    public void testVoidReturnTypeToInt() {
        try {
            initInstance(VoidReturnTypeToInt.class);
        } catch (RuntimeException e) {
            assertReturnTypeException(String.format(EXP_MSG, "voidMethod", "void"), e);
            return;
        }
        fail("Must be failed with return type mismatch exception");
    }

    private void assertArraysEquals(long[] expected, long[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals((Long) actual[i], (Long) expected[i]);
        }
    }

    private void assertReturnTypeException(String expectedMsg, RuntimeException actual) {
        Throwable cause = actual.getCause();
        while (cause != null && !cause.getMessage().equals(expectedMsg)) {
            cause = cause.getCause();
        }
        assertNotNull(cause);
        assertEquals(expectedMsg, cause.getMessage());
    }

    public interface SameReturnType {
        Long doSomething(String str);
    }

    public interface UpCastReturnType {
        Number doSomething(String str);
    }

    public interface ObjectReturnType {
        Object doSomething(String str);
    }

    public interface VoidReturnType {
        void doSomething(String str);
    }

    public interface ArrayReturnType {
        Long[] doSomething(String str);
    }

    public interface CannotCastReturnType {
        Integer doSomething(String str);
    }

    public interface PrimitiveLongArrayReturnType {
        long[] doArray();
    }

    public interface LongArrayReturnType {
        Long[] doArray();
    }

    public interface VoidReturnTypeToVoid {
        void voidMethod();
    }

    public interface VoidReturnTypeToInt {
        int voidMethod();
    }
}
