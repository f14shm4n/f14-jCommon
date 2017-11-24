package f14.common.events;

import java.util.ArrayList;
import java.util.List;

import f14.common.collections.CollectionsUtil;
import f14.common.functions.Action2;

/**
 * Created by f14shm4n on 15.11.2017.
 */

public class EventListenerPool {
    private final ArrayList<IEventListener> listeners;

    public EventListenerPool() {
        listeners = new ArrayList<>();
    }

    public synchronized EventListenerPool register(IEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        }

        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
        return this;
    }

    public synchronized EventListenerPool unregister(IEventListener listener) {
        listeners.remove(listener);
        return this;
    }

    public synchronized void unregisterAll() {
        listeners.clear();
    }

    public synchronized int size() {
        return listeners.size();
    }

    public <T extends IEventListener<E>, E extends IEventArgument> void notify(Class<T> listenerClass, E arg) {
        this.notify(listenerClass, arg, null, false);
    }

    public <T extends IEventListener<E>, E extends IEventArgument> void notify(Class<T> listenerClass, E arg, boolean removeIfFatal) {
        this.notify(listenerClass, arg, null, removeIfFatal);
    }

    public <T extends IEventListener<E>, E extends IEventArgument> void notify(Class<T> listenerClass, E arg, Action2<IEventListener, Throwable> onFatal, boolean removeIfFatal) {
        List<T> listenersToNotify;
        synchronized (this) {
            listenersToNotify = new ArrayList<>();
            CollectionsUtil.forEach(listeners, o -> {
                if (listenerClass.isInstance(o)) {
                    listenersToNotify.add(listenerClass.cast(o));
                }
            });
        }
        CollectionsUtil.forEach(listenersToNotify, l -> {
            try {
                l.handle(arg);
            } catch (Throwable e) {
                if (onFatal != null) {
                    onFatal.Invoke(l, e);
                }
                if (removeIfFatal) {
                    unregister(l);
                }
            }
        });
    }
}
