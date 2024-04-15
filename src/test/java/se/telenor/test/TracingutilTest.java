package se.telenor.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import se.telenor.taf.trace.TraceUtil;
import se.telenor.taf.web.MainPage;

public class TracingutilTest {

    @Test
    public void testTracing() {
        Assert.assertFalse(TraceUtil.buildTree(MainPage.class).isEmpty());
    }
}
