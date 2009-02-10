/**
 * 
 */
package org.openl.rules.tbasic.compile;

class ConversionRuleStep{
    
    private String operationType;
    private String operationParam1;
    private String operationParam2;
    private String labelInstruction;
    
    /**
     * @param operationType
     * @param operationParam1
     * @param operationParam2
     * @param labelInstruction
     */
    public ConversionRuleStep(String operationType, String operationParam1, String operationParam2,
            String labelInstruction) {
        this.operationType = operationType;
        this.operationParam1 = operationParam1;
        this.operationParam2 = operationParam2;
        this.labelInstruction = labelInstruction;
    }
    
    
    /**
     * @return the operationType
     */
    public String getOperationType() {
        return operationType;
    }
    /**
     * @param operationType the operationType to set
     */
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    /**
     * @return the operationParam1
     */
    public String getOperationParam1() {
        return operationParam1;
    }
    /**
     * @param operationParam1 the operationParam1 to set
     */
    public void setOperationParam1(String operationParam1) {
        this.operationParam1 = operationParam1;
    }
    /**
     * @return the operationParam2
     */
    public String getOperationParam2() {
        return operationParam2;
    }
    /**
     * @param operationParam2 the operationParam2 to set
     */
    public void setOperationParam2(String operationParam2) {
        this.operationParam2 = operationParam2;
    }
    /**
     * @return the labelInstruction
     */
    public String getLabelInstruction() {
        return labelInstruction;
    }
    /**
     * @param labelInstruction the labelInstruction to set
     */
    public void setLabelInstruction(String labelInstruction) {
        this.labelInstruction = labelInstruction;
    }
}