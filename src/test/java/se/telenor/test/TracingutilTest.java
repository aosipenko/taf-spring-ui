package se.telenor.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import se.telenor.taf.beans.SomeClassName;
import se.telenor.taf.trace.TraceUtil;
import se.telenor.taf.util.DataHolder;
import se.telenor.taf.web.MainPage;

import java.util.Map;

public class TracingutilTest {

    @SneakyThrows
    @Test
    public void testTracing() {
        Map<String, Object> map = TraceUtil.buildTree(MainPage.class);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
        Assert.assertFalse(map.isEmpty());
    }

    @Test
    public void dataHolderTest() {
        String someString = "testString";
        SomeClassName someClassName = new SomeClassName();
        someClassName.value = "test";
        DataHolder dataHolder = new DataHolder();
        dataHolder.put("test", someString);
        dataHolder.put("test", someClassName);

        SomeClassName extractedValue = dataHolder.get("test", SomeClassName.class);
        String extractedString = dataHolder.get("test", String.class);

        System.out.println(extractedValue.value);
        System.out.println(extractedString);

        DataHolder.reset();

    }
}
