package test.java;

import org.junit.Assert;
import org.junit.Test;

public class ErrorHandlingTest {

    @Test
    public void passesAssertion() {
        Assert.assertTrue(true);
    }

    @Test
    public void failsAssertion() {
        Assert.assertTrue(false);
    }

    @Test
    public void raisesException() throws Exception {
        throw new Exception("Exception!");
    }
}
