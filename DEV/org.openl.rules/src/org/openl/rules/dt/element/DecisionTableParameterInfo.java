package org.openl.rules.dt.element;

import org.openl.rules.dt.IDecisionTableParameterInfo;
import org.openl.types.IParameterDeclaration;

public class DecisionTableParameterInfo implements IDecisionTableParameterInfo {

    private int index;
    private IDecisionRow row;

    public DecisionTableParameterInfo(int index, IDecisionRow row) {
        this.index = index;
        this.row = row;
    }

    public int getIndex() {
        return index;
    }

    public IParameterDeclaration getParameterDeclaration() {
        return row.getParams()[index];
    }

    public String getPresentation() {
        return row.getParamPresentation()[index];
    }

    public IDecisionRow getRow() {
        return row;
    }

    public Object getValue(int ruleN) {


        return row.getParamValue(index, ruleN);
        
    }

}
