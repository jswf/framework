package jwsf.tests;

import jswf.framework.Framework;
import jswf.framework.exceptions.FirstComponentNotProvidedException;
import jswf.framework.exceptions.RunnerNotProvidedException;

import jwsf.tests.dummies.DummyRunner;

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


}

