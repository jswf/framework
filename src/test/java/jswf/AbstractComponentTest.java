package jwsf.tests;

import jswf.framework.Environment;

import jwsf.tests.dummies.DummyComponent;
import jwsf.tests.dummies.OtherDummyComponent;
import org.junit.Test;
import static org.junit.Assert.*;

public class AbstractComponentTest {

    @Test
    public void testSettingAndGettingNextComponent() {
        DummyComponent dummyComponent = new DummyComponent();
        OtherDummyComponent otherDummyComponent = new OtherDummyComponent();

        assertEquals(null, dummyComponent.getNext());

        dummyComponent.setNext(otherDummyComponent);

        assertEquals(otherDummyComponent, dummyComponent.getNext());
    }

    @Test
    public void testInvokingNextComponent() {
        DummyComponent dummyComponent = new DummyComponent();
        Environment environment = new Environment();
        dummyComponent.next(environment);

        assertEquals(null, environment.getCustom("bar"));

        dummyComponent.setNext(new OtherDummyComponent());
        dummyComponent.next(environment);
        assertEquals("foo", environment.getCustom("bar"));
    }

}
