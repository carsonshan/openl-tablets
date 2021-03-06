package org.openl.rules.table.constraints;

import org.openl.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConstraintsParser {
    public static String CONSTRAINTS_SEPARATOR = "&";

    public static List<Constraint> parse(String value) {
        List<Constraint> constraints = new ArrayList<Constraint>();
        ConstraintFactory constraintFactory = new ConstraintFactory();

        if (StringUtils.isNotBlank(value)) {
            for (String constraintExpression : value.split(CONSTRAINTS_SEPARATOR)) {
                Constraint constraint = constraintFactory.getConstraint(constraintExpression);
                if (constraint != null) {
                    constraints.add(constraint);
                }
            }
        }

        return constraints;
    }
}
