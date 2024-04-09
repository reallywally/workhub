package com.wally.workhub.domain.extension;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimeExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private long startTime;

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        String testName = context.getDisplayName();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("Execution time of " + testName + ": " + executionTime + " milliseconds");
    }
}