package jwsf.tests.dummies;

import jswf.framework.AbstractComponent;
import jswf.framework.Environment;
import jswf.framework.ServiceInterface;

public class DummyComponentAndService extends AbstractComponent implements ServiceInterface {

    @Override
    public void invoke(Environment environment) {
        next(environment);
    }

    @Override
    public String getServiceName() {
        return DummyComponentAndService.class.getName();
    }

}