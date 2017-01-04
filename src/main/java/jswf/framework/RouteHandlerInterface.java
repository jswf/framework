package jswf.framework;

/**
 * A generic Route Handler interface.
 * The handle method receives the Environment which contains an instance of the Request and Response objects.
 */
public interface RouteHandlerInterface {

    public void handle(Environment environment) throws Exception;

}