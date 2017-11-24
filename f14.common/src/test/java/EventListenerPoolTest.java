import org.junit.Assert;
import org.junit.Test;

import f14.common.events.EventListenerPool;
import f14.common.events.IEventArgument;
import f14.common.events.IEventListener;

/**
 * Created by f14shm4n on 15.11.2017.
 */

public class EventListenerPoolTest {

    private static int EventListenerFireCount = 0;

    private class TestEventArg1 implements IEventArgument {
    }

    private class TestEventArg2 implements IEventArgument {
    }

    private class TestEventListener1 implements IEventListener<TestEventArg1> {
        @Override
        public void handle(TestEventArg1 arg) throws Throwable {
            EventListenerFireCount++;
            System.out.println("Handle from " + getClass().getSimpleName());
        }
    }

    private class TestEventListener2 implements IEventListener<TestEventArg2> {
        @Override
        public void handle(TestEventArg2 arg) throws Throwable {
            EventListenerFireCount++;
            System.out.println("Handle from " + getClass().getSimpleName());
        }
    }

    private interface TestListener extends IEventListener<TestEventArg1> {
    }

    @Test
    public void HandleForSpecifiedClass() {
        EventListenerPool pool = new EventListenerPool();

        pool.register(new TestEventListener1());
        pool.register(new TestEventListener1());
        pool.register(new TestEventListener2());

        pool.notify(TestEventListener1.class, null, null, false);

        System.out.println("Fired count: " + EventListenerFireCount);

        Assert.assertEquals(2, EventListenerFireCount);
    }

    @Test
    public void HandleForAnonymousClass() {
        EventListenerPool pool = new EventListenerPool();

        pool.register(new TestEventListener1());
        pool.register(new TestEventListener1());
        pool.register(new TestEventListener2());
        pool.register(new IEventListener() {
            @Override
            public void handle(IEventArgument arg) throws Throwable {
                EventListenerFireCount++;
                System.out.println("Handle from " + getClass().getSimpleName());
            }
        });

        pool.notify(IEventListener.class, new TestEventArg2(), null, false);

        System.out.println("Fired count: " + EventListenerFireCount);

        // Call TestEventListener2 and anonymous instance
        Assert.assertEquals(2, EventListenerFireCount);
    }
}
