package jswf.framework;

import java.util.HashMap;

/**
 * Environment is a common ground object for components to interact with each other.
 *
 * It serves as a holder for the components to check the Request and then build or modify the Response.
 */
public class Environment {

    RequestInterface request;

    ResponseInterface response;

    Exception exception;

    String status = "";

    HashMap<String, Object> customs;

    public Environment() {
        this.customs = new HashMap<>();
    }

    /**
     * Sets the request object into the Environment to be used latter by the components.
     *
     * @param request HttpRequest object
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
     * @param response HttpResponse object
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
     * Returns the status value of the Environment.
     * Empty string should indicate it was never set.
     *
     * @return The current status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Compares if the passed status is the same as the current Environment status
     *
     * @param status Status value to compare with
     * @return true if the status value is the same as the passed value
     */
    public boolean isStatus(String status) {
        return this.status.equals(status);
    }

    /**
     * Sets the status of the environment.
     * Status holds a generic String value and could be used to indicate what is the current status of the Environment
     * in in the pipeline.
     *
     * @param status A generic string
     */
    public Environment setStatus(String status) {
        this.status = status;

        return this;
    }

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

    /**
     * Returns true if the exception was previously set otherwise false
     *
     * @return true or false
     */
    public boolean hasException() {
        return exception != null;
    }

}