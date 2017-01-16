package jswf.framework;

/**
 * Basic implementation of a component.
 */
abstract public class AbstractComponent implements ComponentInterface {

    protected ComponentInterface nextComponent;

    /**
     * Sets the next component in the pipeline.
     *
     * @param next The next component to be called
     */
    public void setNext(ComponentInterface next) {
        nextComponent = next;
    }

    /**
     * Returns the next component in the pipeline.
     *
     * @return a ComponentInterface alike object
     */
    public ComponentInterface getNext() {
        return nextComponent;
    }

    /**
     * Invokes the next component in the pipeline
     *
     * @param environment The Environment framework object
     */
    public void next(Environment environment) {
        if (nextComponent != null) {
            nextComponent.invoke(environment);
        }
    }

}
