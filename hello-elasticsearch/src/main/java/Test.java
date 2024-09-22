import org.w3c.dom.ls.LSOutput;

/**
 * @author : fangxiangqian
 * @created : 2023/11/9
 **/
public class Test {

    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int i = 0;
        for(int j = 5; j <= n; j = j + 5) {
            int k = j;
            while (k % 5 == 0) {
                i++;
                k = k / 5;
            }
        }
        return i;
    }



    public static void main(String[] args) {
        Test test = new Test();
        int i = test.trailingZeroes(13);
        System.out.println(i);
    }
}
