package com.epam.geometry.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private TestAppender appender;

    @Before
    public void setUp() {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        final Configuration config = ctx.getConfiguration();
        appender = (TestAppender) config.getAppenders().get("TestAppender");
    }

    @Test
    public void test() {
        //given


        //when


        //then
        //Assert.assertEquals(3, result);
    }
}
