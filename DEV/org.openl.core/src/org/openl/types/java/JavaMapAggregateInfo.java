/*
 * Created on Jul 10, 2003
 *
 * Developed by Intelligent ChoicePoint Inc. 2003
 */

package org.openl.types.java;

import java.util.*;

import org.openl.types.IAggregateInfo;
import org.openl.types.IOpenClass;
import org.openl.types.IOpenIndex;

public class JavaMapAggregateInfo implements IAggregateInfo {

    static class MapIndex implements IOpenIndex {

        IOpenClass elementType;

        MapIndex(IOpenClass elementType) {
            this.elementType = elementType;
        }

        public IOpenClass getElementType() {
            return elementType;
        }

        public IOpenClass getIndexType() {
            return JavaOpenClass.OBJECT;
        }

        @SuppressWarnings("unchecked")
        public Object getValue(Object container, Object index) {
            return ((Map<Object, Object>) container).get(index);
        }

        public boolean isWritable() {
            return true;
        }

        @SuppressWarnings("unchecked")
        public void setValue(Object container, Object index, Object value) {
            ((Map<Object, Object>) container).put(index, value);
        }
    }

    static final IAggregateInfo MAP_AGGREGATE = new JavaMapAggregateInfo();

    public IOpenClass getComponentType(IOpenClass aggregateType) {
        return JavaOpenClass.getOpenClass(Map.Entry.class);
    }

    public IOpenIndex getIndex(IOpenClass aggregateType, IOpenClass indexType) {
        if (!isAggregate(aggregateType)) {
            return null;
        }

        return makeListIndex(aggregateType);
    }

    @SuppressWarnings("unchecked")
    public Iterator<Object> getIterator(Object aggregate) {
        return ((Map) aggregate).entrySet().iterator();
    }

    public boolean isAggregate(IOpenClass type) {
        return Map.class.isAssignableFrom(type.getInstanceClass());
    }

    private IOpenIndex makeListIndex(IOpenClass aggregateType) {
        return new MapIndex(getComponentType(aggregateType));
    }

    @Override
    public IOpenClass getIndexedAggregateType(IOpenClass componentType, int dims) {
        return JavaOpenClass.getOpenClass(Map.class);
    }

    @Override
    public Object makeIndexedAggregate(IOpenClass componentType, int[] dimValues) {
        if (dimValues.length > 1) {
            throw new UnsupportedOperationException("Only one dimensional Java Maps are supported.");
        }

        return new HashMap<Object, Object>(dimValues[0]);
    }
}
