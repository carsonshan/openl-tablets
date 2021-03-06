package org.openl.binding.impl.cast;

/**
 * Emulates type boxing.
 */
final class JavaBoxingCast implements IOpenCast {

    static IOpenCast instance = new JavaBoxingCast();

    private JavaBoxingCast() {
        // Use JavaBoxingCast.instance
    }

    public Object convert(Object from) {
        return from;
    }

    public int getDistance() {
        return CastFactory.JAVA_BOXING_CAST_DISTANCE;
    }

    public boolean isImplicit() {
        return true;
    }

}
