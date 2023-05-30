import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class StosTest {
    private Stos stack;

    @Before
    public void setUp() {
        stack = new Stos(5);
    }

    @Test
    public void testIsEmptyWhenStackNotUsed() {
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testTopWhenStackNotUsed() {
        stack.top();
    }

    @Test(expected = EmptyStackException.class)
    public void testPopWhenStackNotUsed() {
        stack.pop();
    }

    @Test
    public void testPushAndTop() {
        String element = "Test";

        stack.push(element);

        Assert.assertFalse(stack.isEmpty());
        Assert.assertEquals(element, stack.top());
    }

    @Test
    public void testPopAndIsEmpty() {
        String element = "Test";

        stack.push(element);
        String poppedElement = stack.pop();

        Assert.assertSame(element, poppedElement);
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopWhenStackIsEmpty() {
        stack.pop();
    }

    @Test
    public void testMultipleElements() {
        String element1 = "Element 1";
        String element2 = "Element 2";
        String element3 = "Element 3";

        stack.push(element1);
        stack.push(element2);
        stack.push(element3);

        Assert.assertEquals(element3, stack.pop());
        Assert.assertEquals(element2, stack.pop());
        Assert.assertEquals(element1, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushNullAndPop() {
        stack.push(null);

        Assert.assertNull(stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopAfterException() {
        stack.push("Element");
        stack.pop();

        stack.pop(); // This should generate an EmptyStackException
    }
}