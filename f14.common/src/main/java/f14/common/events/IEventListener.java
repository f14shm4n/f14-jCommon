package f14.common.events;

/**
 * Created by f14shm4n on 15.11.2017.
 */

public interface IEventListener<E extends IEventArgument> {
    void handle(E arg) throws Throwable;
}
