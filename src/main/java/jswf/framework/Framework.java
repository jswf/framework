package jswf.framework;

import jswf.framework.exceptions.FirstComponentNotProvidedException;
import jswf.framework.exceptions.RunnerNotProvidedException;

/**
 * Framework class
 */
public class Framework {

    protected AbstractComponent firstComponent;

    protected AbstractComponent currentComponent;

    protected RunnerInterface runner;

    /**
     * Sets the runner to be run when the Framework starts.
     *
     * @param runner Runner object
     *
     * @return this
     */
    public Framework setRunner(RunnerInterface runner) {
        this.runner = runner;

        return this;
    }

    /**
     * Returns the Runner
     *
     * @return Runner or null if it has not been set
     */
    public RunnerInterface getRunner() {
        return runner;
    }

    /**
     * Add a component to the pipeline
     *
     * @param component The component to be added
     * @return this
     */
    public Framework addComponent(AbstractComponent component) {
        if (firstComponent == null) {
            firstComponent = component;
            currentComponent = component;
        } else {
            currentComponent.setNext(component);
            currentComponent = component;
        }

        return this;
    }

    /**
     * Add a component to the pipeline
     *
     * @param component The component to be added
     * @return this
     */
    public Framework addComponent(AbstractComponent component, boolean addAsService) {
        addComponent(component);
        ServicesContainer.addService((ServiceInterface) component);

        return this;
    }

    /**
     * Returns the first component in the pipeline.
     *
     * @return Returns an instance of ComponentInterface.
     */
    public AbstractComponent getComponentsPipeline() {
        return firstComponent;
    }

    /**
     * Invokes the run method of the set runner.
     * jswf.framework.exceptions.RunnerNotProvidedException exception is throw if a runner has not been set.
     * jswf.framework.exceptions.FirstComponentNotProvidedException is throw if at least one component has not been added.
     *
     * @throws Exception
     */
    public void run() throws Exception {
        if (runner == null) {
            throw new RunnerNotProvidedException("A Runner must be defined in order to start the execution.");
        }

        if (firstComponent == null) {
            throw new FirstComponentNotProvidedException("At least one component must be provided in order to start the execution.");
        }

        runner.run(firstComponent);
    }

}
