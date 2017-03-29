package jwsf.tests;

import jwsf.tests.dummies.DummierService;
import jwsf.tests.dummies.DummyService;
import jswf.framework.ServiceInterface;
import jswf.framework.ServicesContainer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;

public class ServicesContainerTests {

    @Before
    public void initialize() {
        ServicesContainer.removeAll();
    }

    @Test
    public void testAddingAndGettingAServiceInstance() {
        assertNull(ServicesContainer.getService(DummyService.class.getName()));
        DummyService dummyService = new DummyService();
        ServicesContainer.addService(dummyService);
        assertEquals(dummyService, ServicesContainer.getService(DummyService.class.getName()));
    }

    @Test
    public void testAddingDifferentServicesUsingTheSameIdentifier() {
        String serviceId = "service";
        assertNull(ServicesContainer.getService(serviceId));
        DummyService dummyService = new DummyService();
        ServicesContainer.addService(serviceId, dummyService);
        assertEquals(dummyService, ServicesContainer.getService(serviceId));
        ServicesContainer.addService(dummyService);
        DummierService dummierService = new DummierService();
        ServicesContainer.addService(serviceId, dummierService);
        assertEquals(dummierService, ServicesContainer.getService(serviceId));
    }

    @Test
    public void testAddingAServiceWithoutProvidingANameForIt() {
        assertNull(ServicesContainer.getService(DummyService.class.getName()));
        DummyService dummyService = new DummyService();
        ServicesContainer.addService(dummyService);
        assertEquals(dummyService, ServicesContainer.getService(DummyService.class.getName()));
    }

    @Test
    public void testAddingServicesAndGettingTheServiceCollection() {
        assertNull(ServicesContainer.getService(DummyService.class.getName()));
        DummyService dummyService = new DummyService();
        ServicesContainer.addService(dummyService);
        Map<String, ServiceInterface> services = ServicesContainer.getServices();
        assertEquals(1, services.size());
        assertTrue(services.containsValue(dummyService));
    }

}
