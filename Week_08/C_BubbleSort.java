import java.util.Arrays;

/**
 * @Author wangwenchao
 * @Date 2020/11/14 01:11
 * @Description 冒泡 逆序 则交换
 * @Version 1.0
 */
public class C_BubbleSort {
    //每次找到最大 放到末尾
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        //都是从 0 开始的 内层到len-1-i
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len-1-i; j++) {
                /**
                 * // 相邻元素两两对比
                 */
                if (arr[j] > arr[j+1]) {
                    swapArr3(arr,j,j+1);
                }
            }
        }
    }

    private void swapArr3(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args) {
        int[] arr ={1,93,2,2,2,11,1,4,5,777,4,32,1,2,-1,3,4,6,7};
        new C_BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println( 1^ 1);

    }

}
