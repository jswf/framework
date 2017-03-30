package jwsf.tests.dummies;

import jswf.framework.ServiceInterface;

public class DummyService implements ServiceInterface {

    @Override
    public String getServiceName() {
        return DummyService.class.getName();
    }
}