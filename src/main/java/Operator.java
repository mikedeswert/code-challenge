import java.util.function.DoubleBinaryOperator;

/**
 * User: mdeswert, Date: 10/10/2017.
 */
public enum Operator {
    ADDITION("+", "\\+", (a, b) -> a + b),
    SUBTRACTION("-", "(?<![+\\-*/])\\-", (a, b) -> a - b),
    MULTIPLICATION("*", "\\*", (a, b) -> a * b),
    DIVISION("/", "/", (a, b) -> a / b);

    private String symbol;
    private String regex;
    private DoubleBinaryOperator execution;

    Operator(String symbol, String regex, DoubleBinaryOperator execution) {
        this.symbol = symbol;
        this.regex = regex;
        this.execution = execution;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getRegex() {
        return regex;
    }

    public DoubleBinaryOperator getExecution() {
        return execution;
    }
}
