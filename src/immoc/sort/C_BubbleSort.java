package src.immoc.sort;

import src.utils.Utils;
import src.utils.Constants;
import src.utils.Utils;

/**
 * 冒泡排序 	两两互换,把最大的放在队尾
 * 每次把最大的放到队尾，i--;
 * 然后再从0~i的队列中把最大的放置队尾 i--;
 * ...
 * 
 * =================================
 * 可不可以将两两互换改为 找到0~i中的最大位置，然后把它跟a[i]互换 这样下来 每轮只进行了一次互换，总共n轮就完事了 貌似会很快
 * 
 * @author xingzhe
 *
 */
public class C_BubbleSort extends AbstractSort {
	@Override
	public void sortDetail(int[] arr) {
		testBubbleSortRechangeAndCopy(arr);
	}
	
	public static void main(String[] args) {
		int[] a = Utils.createRandomArr(10000,1000000);
		C_BubbleSort c_bubbleSort = new C_BubbleSort();
		c_bubbleSort.sortDetail(a);
	}

	private static void testBubbleSortRechangeAndCopy(int[] a) {
		for (int i = a.length-1; i > 0; i--) {
			for (int j = 0; j < i ; j++) {
				if (a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
					Utils.printIntSZ(a);
				}
			}
		}
	}
	//TODO  不知道能不能实现
	private static void testBubbleSortCopy(int[] a) {
			
		for (int i =  0; i < a.length; i++) {
			
			int minIndex = i;//定义0~i中的最大值位置
			int min = a[i];
			for (int j = i+1; j < a.length-1; j++) {
				if (a[j]<min) {
					
					
				}
				
				
			}
			
			
			
		}
		
		
		
	}



}
