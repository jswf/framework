package jwsf.tests.dummies;

import jswf.framework.ComponentInterface;
import jswf.framework.Environment;
import jswf.framework.RunnerInterface;

public class DummyRunner implements RunnerInterface {

    @Override
    public void run(ComponentInterface firstComponent) throws Exception {
        Environment environment = new Environment();

        firstComponent.invoke(environment);
    }

}