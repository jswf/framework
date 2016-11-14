package jswf.framework;

import java.util.HashMap;

/**
 * Interface to define a runner type of object to be passed to the framework
 */
public interface RunnerInterface {

    /**
     * Method to run the pipeline flow by invoking the components
     *
     * @param component First component in the pipeline.
     *                  The implementation should take care of calling at some point component.invoke(environment)
     * @param services Collection of defined services in the Framework
     * @throws Exception
     */
    public void run(ComponentInterface component, HashMap<String, Object> services) throws Exception;

}
