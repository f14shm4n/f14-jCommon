import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import f14.common.collections.CollectionsUtil;
import f14.common.functions.Action;

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
}
