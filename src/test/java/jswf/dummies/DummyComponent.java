package jwsf.tests.dummies;

import jswf.framework.AbstractComponent;
import jswf.framework.Environment;

public class DummyComponent extends AbstractComponent {

    @Override
    public void invoke(Environment environment) {
        next(environment);
    }

}