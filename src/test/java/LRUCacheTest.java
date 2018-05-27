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
    public void testGetValueByFirstKey() {

        cache.put(1, 10);
        cache.put(2, 20);

        int expectedResult = 10;
        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetValueByLastKey() {

        cache.put(4, 40);
        cache.put(5, 50);

        int expectedResult = 50;
        int actualResult = cache.get(5);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetValueByMiddleKey() {

        cache.put(1, 10);
        cache.put(3, 30);
        cache.put(5, 50);

        int expectedResult = 30;
        int actualResult = cache.get(3);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetValueByNonexistentKey() {

        cache.put(2, 20);
        cache.put(5, 50);

        int expectedResult = -1;
        int actualResult = cache.get(6);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPutValueByExistentKey() {

        cache.put(5, 50);
        cache.put(5, 500);

        int expectedResult = 500;
        int actualResult = cache.get(5);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testPutValueByKeyCacheOverflowGetSize() {

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        cache.put(5, 50);

        cache.put(6, 60);

        int expectedResult = 5;
        int actualResult = cache.getSize();

        assertEquals(expectedResult, actualResult);
    }

@Test
    public void testPutValueByKeyCacheOverflowGetLastAfter() {

        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        cache.put(5, 50);

        cache.put(6, 60);

        int expectedResult = -1;
        int actualResult = cache.get(1);

        assertEquals(expectedResult, actualResult);
    }


}
