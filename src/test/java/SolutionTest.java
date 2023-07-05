import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void findMaxFormTest1(){
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        int expected = 4;
        int actual = new Solution().findMaxForm(strs, m, n);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findMaxFormTest2(){
        String[] strs = {"10","0","1"};
        int m = 1;
        int n = 1;
        int expected = 2;
        int actual = new Solution().findMaxForm(strs, m, n);

        Assertions.assertEquals(expected, actual);
    }

}
