package jwsf.tests;

import jswf.framework.Framework;
import jswf.framework.ServicesContainer;
import jswf.framework.exceptions.FirstComponentNotProvidedException;
import jswf.framework.exceptions.RunnerNotProvidedException;

import jwsf.tests.dummies.DummyComponent;
import jwsf.tests.dummies.DummyComponentAndService;
import jwsf.tests.dummies.DummyRunner;

import jwsf.tests.dummies.OtherDummyComponent;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrameworkTests {

    @Test
    public void testSettingAndGettingTheRunnerInstance() {
        Framework framework = new Framework();
        DummyRunner runner = new DummyRunner();
        framework.setRunner(runner);
        assertEquals(runner, framework.getRunner());
    }

    @Test(expected = RunnerNotProvidedException.class)
    public void testTryingToStartWithoutSettingTheRunner() throws Exception {
        Framework framework = new Framework();
        framework.run();
    }

    @Test(expected = FirstComponentNotProvidedException.class)
    public void testTryingToStartWithoutAddingAComponent() throws Exception {
        Framework framework = new Framework();
        DummyRunner runner = new DummyRunner();
        framework.setRunner(runner);
        framework.run();
    }

    @Test
    public void testAddingComponentsToThePipeLine() {
        Framework framework = new Framework();

        DummyComponent dummyComponent = new DummyComponent();
        OtherDummyComponent otherDummyComponent = new OtherDummyComponent();

        framework.addComponent(dummyComponent);

        assertEquals(dummyComponent, framework.getComponentsPipeline());
        assertEquals(null, dummyComponent.getNext());

        framework.addComponent(otherDummyComponent);

        assertEquals(dummyComponent, framework.getComponentsPipeline());
        assertEquals(otherDummyComponent, dummyComponent.getNext());
        assertEquals(null, otherDummyComponent.getNext());
    }

    @Test
    public void testAddingAComponentAsAService() {
        Framework framework = new Framework();
        DummyComponentAndService dummyComponent = new DummyComponentAndService();

        assertEquals(null, ServicesContainer.getService(DummyComponentAndService.class.getName()));

        framework.addComponent(dummyComponent, true);
        assertEquals(dummyComponent, framework.getComponentsPipeline());
        assertEquals(null, dummyComponent.getNext());

        assertEquals(dummyComponent, (DummyComponentAndService) ServicesContainer.getService(DummyComponentAndService.class.getName()));
    }

    @Test
    public void testExecutingRun() throws Exception {
        Framework framework = new Framework();
        DummyRunner dummyRunner = new DummyRunner();
        framework.setRunner(dummyRunner);
        DummyComponent dummyComponent = new DummyComponent();
        framework.addComponent(dummyComponent);
        OtherDummyComponent otherDummyComponent = new OtherDummyComponent();
        framework.addComponent(otherDummyComponent);
        framework.run();

        assertEquals("foo", dummyRunner.environment.getCustom("bar"));
    }


}

