package jswf.framework;

/**
 * Interface to define a runner type of object to be passed to the Framework
 */
public interface RunnerInterface {

    /**
     * Entry point for executing the Runner from the Framework
     *
     * @param firstComponent    First component in the pipeline of the Framework.
     *                          The implementation should take care of calling at some point
     *                          firstComponent.invoke(environment)
     * @throws Exception
     */
    public void run(ComponentInterface firstComponent) throws Exception;

}
