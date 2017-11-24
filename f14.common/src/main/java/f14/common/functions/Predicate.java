package f14.common.functions;

/**
 * Created by f14shm4n on 15.11.2017.
 */

/**
 * Executes the predicate with specified object and return some logical result.
 *
 * @param <T> Type of specified object.
 */
public interface Predicate<T> {
    /**
     * Executes predicate.
     *
     * @param o Some object to check.
     * @return Result logical value.
     */
    boolean apply(T o);
}
