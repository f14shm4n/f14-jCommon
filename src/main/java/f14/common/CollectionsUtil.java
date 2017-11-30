package f14.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import f14.common.functions.*;

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

    public static <T> byte maxByte(Collection<T> collection, Function1<T, Byte> selector) {
        byte value = Byte.MIN_VALUE;
        for (T o : collection) {
            byte curr = selector.run(o);
            value = (byte) Math.max(curr, value);
        }
        return value;
    }

    public static <T> short maxShort(Collection<T> collection, Function1<T, Short> selector) {
        short value = Short.MIN_VALUE;
        for (T o : collection) {
            short curr = selector.run(o);
            value = (short) Math.max(curr, value);
        }
        return value;
    }

    public static <T> int maxInt(Collection<T> collection, Function1<T, Integer> selector) {
        int value = Integer.MIN_VALUE;
        for (T o : collection) {
            int curr = selector.run(o);
            value = Math.max(curr, value);
        }
        return value;
    }

    public static <T> long maxLong(Collection<T> collection, Function1<T, Long> selector) {
        long value = Long.MIN_VALUE;
        for (T o : collection) {
            long curr = selector.run(o);
            value = Math.max(curr, value);
        }
        return value;
    }

    public static <T> float maxFloat(Collection<T> collection, Function1<T, Float> selector) {
        float value = Float.MIN_VALUE;
        for (T o : collection) {
            float curr = selector.run(o);
            value = Math.max(curr, value);
        }
        return value;
    }

    public static <T> double maxDouble(Collection<T> collection, Function1<T, Double> selector) {
        double value = Double.MIN_VALUE;
        for (T o : collection) {
            double curr = selector.run(o);
            value = Math.max(curr, value);
        }
        return value;
    }

    public static <T> byte minByte(Collection<T> collection, Function1<T, Byte> selector) {
        byte value = Byte.MAX_VALUE;
        for (T o : collection) {
            byte curr = selector.run(o);
            value = (byte) Math.min(curr, value);
        }
        return value;
    }

    public static <T> short minShort(Collection<T> collection, Function1<T, Short> selector) {
        short value = Short.MAX_VALUE;
        for (T o : collection) {
            short curr = selector.run(o);
            value = (short) Math.min(curr, value);
        }
        return value;
    }

    public static <T> int minInt(Collection<T> collection, Function1<T, Integer> selector) {
        int value = Integer.MAX_VALUE;
        for (T o : collection) {
            int curr = selector.run(o);
            value = Math.min(curr, value);
        }
        return value;
    }

    public static <T> long minLong(Collection<T> collection, Function1<T, Long> selector) {
        long value = Long.MAX_VALUE;
        for (T o : collection) {
            long curr = selector.run(o);
            value = Math.min(curr, value);
        }
        return value;
    }

    public static <T> float minFloat(Collection<T> collection, Function1<T, Float> selector) {
        float value = Float.MAX_VALUE;
        for (T o : collection) {
            float curr = selector.run(o);
            value = Math.min(curr, value);
        }
        return value;
    }

    public static <T> double minDouble(Collection<T> collection, Function1<T, Double> selector) {
        double value = Double.MAX_VALUE;
        for (T o : collection) {
            double curr = selector.run(o);
            value = Math.min(curr, value);
        }
        return value;
    }
}