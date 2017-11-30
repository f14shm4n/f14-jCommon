import f14.common.CollectionsUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by f14shm4n on 15.11.2017.
 */

public class CollectionUtilTest {
    @Test
    public void typeOf() {
        List<Object> list = new ArrayList<>();

        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add("star");
        list.add("gold");

        Collection<Integer> listTypeOf = CollectionsUtil.typeOf(list, Integer.class);

        Assert.assertEquals(2, listTypeOf.size());
    }

    @Test
    public void maxInt() {
        List<Sample> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(Sample.create(i));
        }

        int max = CollectionsUtil.maxInt(list, o -> o.IntVal);
        Assert.assertEquals(10, max);
    }

    @Test
    public void minInt() {
        List<Sample> list = new ArrayList<>();
        list.add(Sample.create(0));
        list.add(Sample.create(1));
        list.add(Sample.create(3));
        list.add(Sample.create(5));

        int max = CollectionsUtil.minInt(list, o -> o.IntVal);
        Assert.assertEquals(0, max);
    }

    @Test
    public void minDouble() {
        List<Sample> list = new ArrayList<>();
        list.add(Sample.create(0.13));
        list.add(Sample.create(0.11));
        list.add(Sample.create(6));
        list.add(Sample.create(1.12));

        double max = CollectionsUtil.minDouble(list, o -> o.DoubleVal);
        Assert.assertEquals(0.11, max, 0);
    }

    private static class Sample {
        public int IntVal;
        public long LongVal;
        public float FloatVal;
        public double DoubleVal;

        public static <T extends Number> Sample create(T val) {
            Sample t = new Sample();
            t.IntVal = val.intValue();
            t.LongVal = val.longValue();
            t.FloatVal = val.floatValue();
            t.DoubleVal = val.doubleValue();
            return t;
        }
    }

}
