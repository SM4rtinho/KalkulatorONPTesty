import java.util.EmptyStackException;
import java.util.Stack;

public class ONPCalculator {
    private Stos stack;

    public ONPCalculator() {
        stack = new Stos(100); // Określ pojemność stosu
    }

    public double calculate(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(token);
            } else {
                double operand2 = Double.parseDouble(stack.pop());
                double operand1 = Double.parseDouble(stack.pop());
                double result = evaluate(operand1, operand2, token);
                stack.push(Double.toString(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private double evaluate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0)
                    throw new ArithmeticException("Nie możesz dzielić przez 0.");
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Nieprawidłowy operator: " + operator);
        }
    }
}
