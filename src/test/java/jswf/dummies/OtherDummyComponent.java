package jswf.dummies;

import jswf.framework.AbstractComponent;
import jswf.framework.Environment;

public class OtherDummyComponent extends AbstractComponent {

    @Override
    public void invoke(Environment environment) {
        environment.setCustom("bar", "foo");
    }

}