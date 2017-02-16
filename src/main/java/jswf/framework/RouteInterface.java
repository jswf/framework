package jswf.framework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Generic route definition
 */
public interface RouteInterface {

    /**
     * Returns the route name
     *
     * @return Route name
     */
    public String getName();

    /**
     * Sets the route name
     *
     * @param name Route name
     * @return RouteInterface
     */
    public RouteInterface setName(String name);

    /**
     * Returns the route uri
     *
     * @return Route uri
     */
    public String getUri();

    /**
     * Sets the route uri
     *
     * @param uri Route uri
     * @return RouteInterface
     */
    public RouteInterface setUri(String uri);

    /**
     * Returns the route compiled path pattern
     *
     * @return Route compiled path
     */
    public Pattern getCompiledPath();

    /**
     * Sets the route compiled path
     *
     * @param compiledPath Route compiled path
     * @return RouteInterface
     */
    public RouteInterface setCompiledPath(Pattern compiledPath);

    /**
     * Returns the route handler
     *
     * @return Route handler class
     */
    public Class<?> getHandler();

    /**
     * Sets the route handler
     *
     * @param handler Route handler class
     * @return RouteInterface
     */
    public RouteInterface setHandler(Class<?> handler);

    /**
     * Returns the Matcher object
     * @param uri Uri to check against
     * @return Matcher
     */
    public Matcher matcher(String uri);

    /**
     * Returns true if the uri matches the route
     *
     * @param uri Uri to check against
     * @return True if it matches
     */
    public boolean matches(String uri);

}
