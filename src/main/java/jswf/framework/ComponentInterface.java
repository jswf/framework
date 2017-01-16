package jswf.framework;

/**
 * Interface to define a framework component.
 *
 * A component is responsible for implementing the invoke method.
 * A component is responsible for calling the next component in the pipeline by calling next(environment) from within the invoke method.
 */
public interface ComponentInterface {

    /**
     * Sets the next component in the pipeline.
     *
     * @param next The next component to be called
     */
    public void setNext(ComponentInterface next);

    /**
     * Returns the next component in the pipeline.
     *
     * @return a ComponentInterface alike object
     */
    public ComponentInterface getNext();

    /**
     * Passe the environment to the next component in the pipeline
     *
     * @param environment The Environment framework object
     */
    public void next(Environment environment);

    /**
     * Invokes the next component in the pipeline
     *
     * @param environment The Environment framework object
     */
    public void invoke(Environment environment);

}
