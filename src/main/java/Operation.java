import java.util.List;

/**
 * User: mdeswert, Date: 10/10/2017.
 */
public class Operation implements Operand {
    private final Operator operator;
    private final List<Operand> operands;

    public Operation(Operator operator, List<Operand> operands) {
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public double getValue() {
        return operands.stream()
                .mapToDouble(Operand::getValue)
                .reduce(operator.getExecution())
                .orElseThrow(() -> new IllegalStateException("Unable to calculate value."));
    }
}
