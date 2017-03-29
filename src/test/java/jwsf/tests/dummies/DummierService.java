package jwsf.tests.dummies;

import jswf.framework.ServiceInterface;

public class DummierService  implements ServiceInterface {

    @Override
    public String getServiceName() {
        return DummierService.class.getName();
    }
}