package src.immoc.sort;

import src.utils.Utils;

/**
 * 交换排序：冒泡排序、快速排序
 * @author xingzhe
 *
 */
public class ChangeSortDemo {
	public static void main(String[] args) {
		int[] arr = { 1, 9, 6, 8, 11, 77, 99, 0, 5, 2, 3 };
		System.out.println("arr.length:"+arr.length);
		System.out.println("arr:" + Utils.printIntSZ(arr));
		System.out.println("========================================================");
		int[] after = sort(arr);
		System.out.println("after0:" + Utils.printIntSZ(after));
		int[] arr2 = { 1, 9, 6, 8, 11, 77, 99, 0, 5, 2, 3 };

		int[] after2 = sortBackUp(arr2);
		System.out.println("after2:" + Utils.printIntSZ(after2));
		int[] arr3 = { 1, 9, 6, 8, 11, 77, 99, 0, 5, 2, 3 };

		int[] after3 = sortZX(arr3);
		System.out.println("after3:" + Utils.printIntSZ(after3));
	}

	/**
	 * 冒泡排序
	 * 
	 * @author wly
	 * @date 2013-10-19
	 */
	public static int[] sort(int[] inputArray) {
		int count = 0;
		if (inputArray.length <= 1) {
			return inputArray;
		} else {
			for (int j = inputArray.length; j > 1; j--) {
				int max = inputArray[0]; // 注意：一次大循环结束后，需要将max的值重置一下，否则会出错
				for (int i = 0; i < j; i++) { // 注意：i<j,j的不断变小因为未完成排序的元素越来越少了
					if (inputArray[i] < max) { // 交换相邻两个元素
						inputArray[i - 1] = inputArray[i];
						inputArray[i] = max;
					} else { // 移动标记位置
						max = inputArray[i];
					}
					count ++;
				}
			}
			System.out.println(count);
			return inputArray;
		}
	}

	public static int[] sortBackUp(int[] aa) {
		int count = 0;
		if (aa.length > 0) {
			for (int j = aa.length - 1; j > 0; j--) {
				int max = aa[0];// ** 注意：一次大循环结束后，需要将max的值重置一下，否则会出错
				for (int i = 1; i <= j; i++) {
					// for(int i =0 ;i < j; i++){//i
					// 可以从从第二个元素开始，因为第一个就是每次j遍历的i=0的值就aa[0]
					if (aa[i] < max) {// jiao
						aa[i - 1] = aa[i];
						aa[i] = max;
					} else {
						max = aa[i];
					}
					count ++;
				}
			}
		}
		System.out.println(count);
		return aa;
	}
	
	/**

	 *  冒泡排序
	 *  
	 *  
	 *  
	 *  
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。 
	 * @param a
	 * @return
	 */
	public static int[] sortZX(int[] a){
		int count =0;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j<a.length-i-1; j++){//为什么是 -i 因为a.length-1-i之后的都是大的
                //这里-i主要是每遍历一次都把最大的i个数沉到最底下去了，没有必要再替换了
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
                count ++;
            }
        }
        System.out.println(count);
		return a;
	}
}
