package org.openl.rules.table.properties.expressions.match;

import org.apache.commons.lang.StringUtils;

public class MatchingExpressionsParser {
    
    public static IMatchingExpression parse(String matchingExpressionStr) {
        
        String operationName = null; 
        String contextAttribute = null; 
        if (StringUtils.isNotEmpty(matchingExpressionStr)) {
            int openBracketIndex = matchingExpressionStr.indexOf("(");
            int closeBracketIndex = matchingExpressionStr.indexOf(")");

            operationName = matchingExpressionStr.substring(0, openBracketIndex).toUpperCase();
            contextAttribute = matchingExpressionStr.substring(openBracketIndex + 1, closeBracketIndex);
        } else {
            throw new RuntimeException("Matching expression string is null");
        }
        
        if (StringUtils.isEmpty(operationName) || StringUtils.isEmpty(contextAttribute)) {
            throw new RuntimeException("Wrong matching expression format. Expected: <operationName>(<contextAttribute>)");
        }
        
        MatchingExpressionFactory metchExpressionFactory = new MatchingExpressionFactory();
        
        return metchExpressionFactory.getMatchingExpression(operationName, contextAttribute);
    }

}
