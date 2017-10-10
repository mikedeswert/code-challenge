import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * User: mdeswert, Date: 10/10/2017.
 */
public class Calculator {
    public double calculate(String expression) {
        String sanitizedExpression = expression.replaceAll("[^\\+\\-\\*/0-9]", "");
        return createOperation(Precedence.getFirstOperator(), sanitizedExpression).getValue();
    }

    private Operation createOperation(Operator operator, String input) {
        List<Operand> operands = getOperandsAsStrings(operator, input)
                .map(operandAsString -> createOperand(operator, operandAsString))
                .collect(toList());

        return new Operation(operator, operands);
    }

    private Stream<String> getOperandsAsStrings(Operator operator, String input) {
        return stream(input.split(operator.getRegex()));
    }

    private Operand createOperand(Operator operator, String operandAsString) {
        if (containsOperators(operandAsString)) {
            return createOperation(Precedence.getNextOperatorAfter(operator), operandAsString);
        }
        return new Value(operandAsString);
    }

    private boolean containsOperators(String operandAsString) {
        return stream(Operator.values())
                .map(Operator::getSymbol)
                .anyMatch(operandAsString::contains) && isNotNegativeNumber(operandAsString);
    }

    private boolean isNotNegativeNumber(String operandAsString) {
        return !operandAsString.startsWith("-");
    }
}
