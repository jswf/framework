package framework;

import java.util.HashMap;

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
     * @param services          Collection of defined services in the Framework
     * @throws Exception
     */
    public void run(ComponentInterface firstComponent, HashMap<String, Object> services) throws Exception;

}
