package org.openl.rules.validation;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.openl.OpenL;
import org.openl.domain.IDomain;
import org.openl.message.OpenLMessage;
import org.openl.message.OpenLMessagesUtils;
import org.openl.rules.dt.IBaseCondition;
import org.openl.rules.dt.IDecisionTable;
import org.openl.rules.dt.type.domains.DomainAdaptorFactory;
import org.openl.rules.dt.type.domains.IDomainAdaptor;
import org.openl.rules.dt.validator.DecisionTableAnalyzer;
import org.openl.rules.dt.validator.DecisionTableValidationResult;
import org.openl.rules.dt.validator.DecisionTableValidator;
import org.openl.rules.enumeration.ValidateDTEnum;
import org.openl.rules.lang.xls.syntax.TableSyntaxNode;
import org.openl.rules.method.ExecutableRulesMethod;
import org.openl.syntax.exception.SyntaxNodeException;
import org.openl.syntax.exception.SyntaxNodeExceptionUtils;
import org.openl.types.IOpenClass;
import org.openl.types.IOpenMethod;
import org.openl.types.IParameterDeclaration;
import org.openl.validation.ValidationResult;

/**
 * Gap/overlap analysis for Decision Tables with property "validateDT" == "on".
 * 
 * @author PUdalau
 */
public class GapOverlapValidator extends TablesValidator {

    private static final String VALIDATION_FAILED = "Validation failed for node : ";

    @Override
    public ValidationResult validateTables(OpenL openl, TableSyntaxNode[] tableSyntaxNodes, IOpenClass openClass) {
        List<IOpenMethod> allModuleMethods = OpenMethodDispatcherHelper.extractMethods(openClass);

        Collection<OpenLMessage> messages = new LinkedHashSet<>();

        for (IOpenMethod method : allModuleMethods) {
            if (method instanceof ExecutableRulesMethod) {
                ExecutableRulesMethod executableMethod = (ExecutableRulesMethod) method;
                if (isValidatableMethod(executableMethod)) {
                    // can cast to DecisionTable, as validateDT property belongs
                    // only to DT.
                    //
                    IDecisionTable decisionTable = (IDecisionTable) executableMethod;
                    DecisionTableValidationResult dtValidResult = validate(messages, openClass, decisionTable);
                    if (dtValidResult != null && dtValidResult.hasProblems()) {
                        decisionTable.getSyntaxNode().setValidationResult(dtValidResult);
                        if (dtValidResult.hasErrors()) {
                            addError(messages, decisionTable.getSyntaxNode(), dtValidResult.toString());
                        } else {
                            messages.add(OpenLMessagesUtils.newWarnMessage(dtValidResult.toString(),
                                decisionTable.getSyntaxNode()));
                        }
                    }
                }
            }
        }
        return ValidationUtils.withMessages(messages);
    }

    private void addError(Collection<OpenLMessage> messages, TableSyntaxNode tableSyntaxNode, String message) {
        SyntaxNodeException sne = SyntaxNodeExceptionUtils.createError(message, tableSyntaxNode);
        tableSyntaxNode.addError(sne);
        messages.add(OpenLMessagesUtils.newErrorMessage(sne));
    }

    private DecisionTableValidationResult validate(Collection<OpenLMessage> messages,
            IOpenClass openClass,
            IDecisionTable decisionTable) {
        DecisionTableValidationResult dtValidResult = null;
        try {
            Map<String, IDomainAdaptor> domains = gatherDomains(decisionTable);
            dtValidResult = DecisionTableValidator.validateTable(decisionTable, domains, openClass);
        } catch (Exception t) {
            String errorMessage = String.format("%s%s.Reason : %s",
                VALIDATION_FAILED,
                decisionTable.getSyntaxNode().getDisplayName(),
                t.getMessage());
            addError(messages, decisionTable.getSyntaxNode(), errorMessage);
        }
        return dtValidResult;
    }

    private Map<String, IDomainAdaptor> gatherDomains(IDecisionTable dt) throws Exception {
        Map<String, IDomainAdaptor> domainsMap = new HashMap<String, IDomainAdaptor>();
        DecisionTableAnalyzer analyzer = new DecisionTableAnalyzer(dt);

        for (IBaseCondition condition : dt.getConditionRows()) {
            // List<IParameterDeclaration> parameters =
            // getAllParameters(condition, analyzer);

            IParameterDeclaration[] pd = analyzer.referencedSignatureParams(condition);
            for (int i = 0; i < pd.length; i++) {
                IDomain<?> domain = pd[i].getType().getDomain();
                if (domain == null) {
                    domain = condition.getConditionEvaluator().getRuleParameterDomain(condition);
                    IDomainAdaptor adaptor = DomainAdaptorFactory.getAdaptor(domain);
                    domainsMap.put(pd[i].getName(), adaptor);
                }
            }

            IParameterDeclaration[] cparams = condition.getParams();

            for (int i = 0; i < cparams.length; i++) {
                IDomain<?> domain = cparams[i].getType().getDomain();
                if (domain == null) {
                    domain = condition.getConditionEvaluator().getConditionParameterDomain(i, condition);
                    if (domain != null) {
                        IDomainAdaptor adaptor = DomainAdaptorFactory.getAdaptor(domain);
                        domainsMap.put(
                            DecisionTableValidator.getUniqueConditionParamName(condition, cparams[i].getName()),
                            adaptor);
                    }

                }

            }

        }
        return domainsMap;
    }

    /**
     * @return all parameter declarations: from signature and local from
     *         condition
     */
    // private List<IParameterDeclaration> getAllParameters(ICondition
    // condition, DecisionTableAnalyzer analyzer) {
    // List<IParameterDeclaration> result = new
    // ArrayList<IParameterDeclaration>();
    // IParameterDeclaration[] paramDeclarations = condition.getParams();
    // result.addAll(Arrays.asList(paramDeclarations));
    // IParameterDeclaration[] referencedSignatureParams =
    // analyzer.referencedSignatureParams(condition);
    // result.addAll(Arrays.asList(referencedSignatureParams));
    // return result;
    // }

    /**
     * @param condition Condition to check for variables without domain.
     * @return <code>null</code> if there is no variables without domain
     *         otherwise the domain for variables without domain.
     */
    // private IDomain<?>
    // findDomainForConditionVariables(List<IParameterDeclaration> parameters,
    // ICondition condition,
    // DecisionTableAnalyzer analyzer) {
    // IDomain<?> domain = null;
    // for (IParameterDeclaration parameter : parameters) {
    // domain = parameter.getType().getDomain();
    // if (domain == null) {
    // domain = analyzer.gatherDomainFromValues(parameter, condition);
    // }
    // }
    // return domain;
    // }

    private static boolean isValidatableMethod(ExecutableRulesMethod executableMethod) {
        return executableMethod.getMethodProperties() != null && ValidateDTEnum.ON
            .equals(executableMethod.getMethodProperties().getValidateDT());
    }
}
