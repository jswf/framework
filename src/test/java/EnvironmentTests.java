import jswf.framework.Environment;
import jswf.framework.RequestInterface;
import jswf.framework.ResponseInterface;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class EnvironmentTests {

    @Test
    public void testCustomsAreInitialized() {
        Environment environment = new Environment();
        HashMap<String, Object> customs = environment.getCustoms();
        assertNotNull(customs);
    }

    @Test
    public void testSettingRequestAndResponse() {
        DummyRequest request = new DummyRequest();
        DummyResponse response = new DummyResponse();
        Environment environment = new Environment();
        environment.setRequest(request);
        environment.setResponse(response);
        assertEquals(request, environment.getRequest());
        assertEquals(response, environment.getResponse());
    }

    @Test
    public void testSettingGettingAndCheckingStatus() {
        Environment environment = new Environment();
        String status = "done";
        environment.setStatus(status);
        assertEquals(status, environment.getStatus());
        assertTrue(environment.isStatus(status));
        assertTrue(environment.isStatus("done"));
        assertFalse(environment.isStatus("processing"));
    }

    @Test
    public void testSettingGettingAndCheckingException() {
        Environment environment = new Environment();
        Exception exception = new Exception();
        environment.setException(exception);
        assertEquals(exception, environment.getException());
        assertTrue(environment.hasException());
    }

    @Test
    public void testSettingAndGettingCustomVariables() {
        Environment environment = new Environment();
        String custom1 = "customString";
        int custom2 = 10000;
        long custom3 = 100L;
        String custom4 = new String("custom4");
        environment.setCustom("custom1", custom1);
        environment.setCustom("custom2", custom2);
        assertEquals(custom1, environment.getCustom("custom1"));
        assertEquals(custom2, environment.getCustom("custom2"));
        HashMap<String, Object> customs = new HashMap<>();
        customs.put("custom3", custom3);
        customs.put("custom4", custom4);
        environment.setCustoms(customs);
        assertEquals(customs, environment.getCustoms());
        assertEquals(custom3, environment.getCustom("custom3"));
        assertEquals(custom4, environment.getCustom("custom4"));
    }

}

class DummyRequest implements RequestInterface {}
class DummyResponse implements ResponseInterface {}