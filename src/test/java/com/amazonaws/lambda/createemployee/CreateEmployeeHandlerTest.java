package com.amazonaws.lambda.createemployee;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.lambda.createemployee.model.Employee;
import com.amazonaws.lambda.createemployee.model.MyAppResponse;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class CreateEmployeeHandlerTest {

    private static Object input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = null;
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testCreateEmployeeHandler() {
        CreateEmployeeHandler handler = new CreateEmployeeHandler();
        Context ctx = createContext();

        MyAppResponse output = handler.handleRequest(new Employee(), ctx);

        // TODO: validate output here if needed.
        Assert.assertEquals("Hello from Lambda!", output);
    }
}
