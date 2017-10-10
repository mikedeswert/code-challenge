import java.util.List;

import static java.util.Arrays.asList;

/**
 * User: mdeswert, Date: 10/10/2017.
 */
public class Precedence {
    private static final List<Operator> OPERATOR_ORDER = asList(
            Operator.ADDITION,
            Operator.SUBTRACTION,
            Operator.MULTIPLICATION,
            Operator.DIVISION);


    public static Operator getFirstOperator() {
        return OPERATOR_ORDER.get(0);
    }

    public static Operator getNextOperatorAfter(Operator operator) {
        return OPERATOR_ORDER.get(OPERATOR_ORDER.indexOf(operator) + 1);
    }
}
