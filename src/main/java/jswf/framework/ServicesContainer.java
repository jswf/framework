package jswf.framework;

import java.util.IdentityHashMap;

/**
 * Singleton instance to hold the list of services to be used by the application
 */
public class ServicesContainer {

    static private ServicesContainer instance;

    private IdentityHashMap<String, ServiceInterface> services;

    private ServicesContainer() {
        services = new IdentityHashMap<>();
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
     * @return An IdentityHashMap holding the defined services
     */
    public static IdentityHashMap<String, ServiceInterface> getServices() {
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

}
