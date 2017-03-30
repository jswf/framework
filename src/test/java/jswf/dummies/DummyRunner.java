package jswf.dummies;

import jswf.framework.ComponentInterface;
import jswf.framework.Environment;
import jswf.framework.RunnerInterface;

public class DummyRunner implements RunnerInterface {

    public Environment environment;

    @Override
    public void run(ComponentInterface firstComponent) throws Exception {
        environment = new Environment();

        firstComponent.invoke(environment);
    }

}