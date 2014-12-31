package org.openl.rules.types.impl;

import org.openl.binding.MethodUtil;
import org.openl.rules.dt.DecisionTable;
import org.openl.rules.table.ATableTracerNode;
import org.openl.rules.table.GridTableUtils;
import org.openl.rules.table.IGridRegion;
import org.openl.rules.table.ILogicalTable;
import org.openl.types.IOpenMethod;

import java.util.List;

/**
 * Trace object for step of choosing the method from overloaded by properties
 * group of tables.
 *
 * @author PUdalau
 */
public class OverloadedMethodChoiceTraceObject extends ATableTracerNode {
    private List<IOpenMethod> methodCandidates;

    public OverloadedMethodChoiceTraceObject(DecisionTable dispatcherTable, Object[] params,
                                             List<IOpenMethod> methodCandidates) {
        super("overloadedMethodChoice", null, dispatcherTable, params);
        this.methodCandidates = methodCandidates;
    }

    public List<IGridRegion> getGridRegions() {
        IOpenMethod method = (IOpenMethod) getResult();
        int methodIndex = methodCandidates.indexOf(method);

        ILogicalTable table = ((DecisionTable) getTraceObject()).getRuleTable(methodIndex);
        return GridTableUtils.getGridRegions(table);
    }

    @Override
    public String getDisplayName(int mode) {
        return "Overloaded method choice for method " + MethodUtil.printMethod(methodCandidates.get(0), 0, false);
    }
}