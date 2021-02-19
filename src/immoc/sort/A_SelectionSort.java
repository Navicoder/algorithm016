package src.immoc.sort;

import src.utils.Utils;
import src.utils.Constants;
import src.utils.Utils;


/**
 * O(n^2)
 * 选择排序  每一次循环选出最小的一个跟第一个比 然后交换
 * 10万 16786ms 16~17s; 100万  30分钟
 * 1千 16ms
 *
 * 选择排序每次都会全遍历；
 *
 * @author xingzhe
 *
 */
public class A_SelectionSort extends AbstractSort{
	 public static void main(String[] args) {
		int[] a = Utils.createRandomArr(10,100);
		new A_SelectionSort().sort(a);
	 }
	@Override
	public void sortDetail(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex=i;//最小值的索引位置
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
					if (arr[i] > arr[j]) {
						//交换
						Utils.swap(arr,i,j);
					}
				}
			}
		}
	}
}
