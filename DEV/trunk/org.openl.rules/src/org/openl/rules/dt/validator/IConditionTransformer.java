/**
 * Created Feb 7, 2007
 */
package org.openl.rules.dt.validator;

import org.openl.rules.dt.element.ICondition;
import org.openl.types.IOpenClass;
import org.openl.types.IParameterDeclaration;

import com.exigen.ie.constrainer.Constrainer;
import com.exigen.ie.constrainer.IntVar;

/**
 * @author snshor
 * 
 */
public interface IConditionTransformer {

    IntVar makeSignatureVar(String parameterName, IOpenClass clazz, Constrainer constrainer);

    IOpenClass transformParameterType(IParameterDeclaration declaration);

    Object transformParameterValue(String name,
            ICondition condition,
            Object value,            
            DecisionTableAnalyzer analyzer);

    IOpenClass transformSignatureType(IParameterDeclaration parameterDeclaration);

    Object transformSignatureValueBack(String name, int intValue, DecisionTableAnalyzer analyzer);

}
