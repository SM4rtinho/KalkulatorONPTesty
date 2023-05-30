import java.util.EmptyStackException;

public class Stos {
    private String[] elements;
    private int top;

    public Stos(int capacity) {
        elements = new String[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public void push(String element) {
        if (isFull()) {
            throw new IllegalStateException("Stos jest pełny");
        }
        elements[++top] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top--];
    }

    public String top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[top];
    }
}