import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class LRUCacheTest {

    private LRUCache cache;

    @Before
    public void init() {
        cache = new LRUCache(5);
    }

    @Test
    public void testGetValueByKey() {

        cache.put(1, 40);

        int expectedResult = 40;
        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPutValueByKey() {

        cache.put(1, 50);

        int expectedResult = 50;
        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }
}
