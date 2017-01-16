package framework;

import java.util.HashMap;

/**
 * Environment is a common ground object for components to interact with each other.
 *
 * It serves as a holder for the components to check the Request and then build or modify the Response.
 */
public class Environment {

    HashMap<String, Object> services;

    RequestInterface request;

    ResponseInterface response;

    Exception exception;

    HashMap<String, Object> customs;

    public Environment(HashMap<String, Object> services) {
        this.services = services;
        this.customs = new HashMap<>();
    }

    /**
     * Sets the request object into the Environment to be used latter by the components.
     *
     * @param request Request object
     * @return this
     */
    public Environment setRequest(RequestInterface request) {
        this.request = request;

        return this;
    }

    /**
     * Returns the current request object.
     *
     * @return RequestInterface object type
     */
    public RequestInterface getRequest() {
        return request;
    }

    /**
     * Sets the response object into the Environment to be used latter by the components.
     *
     * @param response Response object
     * @return this
     */
    public Environment setResponse(ResponseInterface response) {
        this.response = response;

        return this;
    }

    /**
     * Returns the current response object.
     *
     * @return ResponseInterface object
     */
    public ResponseInterface getResponse() {
        return response;
    }

    /**
     * Sets a custom object type into the environment to pass objects between components.
     *
     * @param id Id of the custom object
     * @param object Custom object
     * @return this
     */
    public Environment setCustom(String id, Object object) {
        customs.put(id, object);

        return this;
    }

    /**
     * Returns a custom object if it exist otherwise null.
     *
     * @param id Custom object id to look for
     * @return An object
     */
    public Object getCustom(String id) {
        return customs.get(id);
    }

    /**
     * Sets the custom objects HashMap. Custom objects are to be used to pass objects between componets.
     *
     * @param customs A HashMap
     * @return this
     */
    public Environment setCustoms(HashMap<String, Object> customs) {
        this.customs = customs;

        return this;
    }

    /**
     * Returns the custom objects HashMap
     *
     * @return A HashMap
     */
    public HashMap<String, Object> getCustoms() {
        return customs;
    }

    /**
     * Returns the list of services declared in the Framework.
     *
     * @return A HashMap
     */
    public HashMap<String, Object> getServices() { return services; }

    /**
     * Returns a service by its id if it exists otherwise null.
     *
     * @param id Service id
     * @return An Object
     */
    public Object getService(String id) { return services.get(id); }

    /**
     * Sets an exception in the Environment to notify the other components something happened in the pipeline.
     *
     * @param exception Exception
     * @return this
     */
    public Environment setException(Exception exception) {
        this.exception = exception;

        return this;
    }

    /**
     * Returns an exception if it was previously set by a component otherwise null.
     *
     * @return Exception or Null
     */
    public Exception getException() {
        return exception;
    }

}