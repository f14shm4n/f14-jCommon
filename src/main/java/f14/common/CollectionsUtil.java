package f14.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import f14.common.functions.Action1;
import f14.common.functions.Predicate;

/**
 * Created by f14shm4n on 15.11.2017.
 */

public final class CollectionsUtil {

    public static <T, R> List<R> typeOf(Collection<T> collection, Class<R> caster) {
        List<R> result = new ArrayList<>();
        for (T o : collection) {
            if (caster.isInstance(o)) {
                result.add(caster.cast(o));
            }
        }
        return result;
    }

    public static <T> void forEach(Collection<T> collection, Action1<T> action) {
        for (T o : collection) {
            action.run(o);
        }
    }

    public static <T> T firstOrNull(Collection<T> collection, Predicate<T> predicate) {
        for (T o : collection) {
            if (predicate.test(o)) {
                return o;
            }
        }
        return null;
    }

    public static <T> List<T> where(Collection<T> collection, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T o : collection) {
            if (predicate.test(o)) {
                result.add(o);
            }
        }
        return result;
    }

    public static <T> boolean any(Collection<T> collection, Predicate<T> predicate) {
        for (T o : collection) {
            if (predicate.test(o)) {
                return true;
            }
        }
        return false;
    }
}