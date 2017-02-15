package jswf.framework;

import java.util.HashMap;

public class ServicesContainer {

    static private ServicesContainer instance;

    private HashMap<String, ServiceInterface> services;

    private ServicesContainer() {
        services = new HashMap<>();
    }

    protected static ServicesContainer getInstance() {
        if (instance == null) {
            instance = new ServicesContainer();
        }

        return instance;
    }

    public static ServiceInterface getService(String name) {
        return getInstance().services.get(name);
    }

    public static HashMap<String, ServiceInterface> getServices() {
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
