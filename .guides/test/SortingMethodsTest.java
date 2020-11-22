

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SortingMethodsTest {
    @Parameters(name="{0}")
    public static Object[][] data() {
        return new Object[][] { //
            { Arrays.asList(-99, 34, -41, -96, 60, -45, 67, -48, -60, 93)}, // unordered
            { Arrays.asList(-99, -96, -60, -48, -45, -41, 34, 60, 67, 93)}, // ascending
            { Arrays.asList(93, 67, 60, 34, -41, -45, -48, -60, -96, -99)}, // descending
            { Arrays.asList()}, // empty
            { Arrays.asList(5)}, // singleton
            { Arrays.asList(2, 1)}, // pair
        };
    }

    private int[] a;
    
    public SortingMethodsTest(List<Integer> list) {
        this.a = list.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
        int[] copy = Arrays.copyOf(a, a.length);
        int[] sortedCopy = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedCopy);

        Method sortMethod = TestUtilities.getPublicStaticMethod("dualSelectionSort", SortingMethods.class, Void.TYPE, int[].class);
        TestUtilities.invoke(sortMethod, null, a);
//        SortingMethods.dualSelectionSort(a);

        assertArrayEquals(a, sortedCopy);
    }
}
