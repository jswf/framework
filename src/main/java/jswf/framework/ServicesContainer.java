package jswf.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton instance to hold the list of services to be used by the application
 */
public class ServicesContainer {

    static private ServicesContainer instance;

    private Map<String, ServiceInterface> services;

    private ServicesContainer() {
        services = new HashMap<>();
    }

    protected static ServicesContainer getInstance() {
        if (instance == null) {
            instance = new ServicesContainer();
        }

        return instance;
    }

    /**
     * Returns a ServiceInterface instance if found by the name otherwise null
     * @param name Service name
     * @return ServiceInterface
     */
    public static ServiceInterface getService(String name) {
        return getInstance().services.get(name);
    }

    /**
     * Returns the list of services
     *
     * @return An Map holding the defined services
     */
    public static Map<String, ServiceInterface> getServices() {
        return getInstance().services;
    }

    /**
     * Adds a service to the services list.
     *
     * @param name Name of the service
     * @param service Service object
     * @return this
     */
    public static ServicesContainer addService(String name, ServiceInterface service) {
        ServicesContainer instance = getInstance();
        instance.services.put(name, service);

        return instance;
    }

    /**
     * Adds a service to the service list, the class name of the service will be used as unique identifier
     *
     * @param service Service object
     * @return this
     */
    public static ServicesContainer addService(ServiceInterface service) {
        return getInstance().addService(service.getClass().getName(), service);
    }

    /**
     * Removes all the current registered services
     */
    public static void removeAll() {
        getInstance().services.clear();
    }

}
