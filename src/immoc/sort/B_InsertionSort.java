package src.immoc.sort;

import src.utils.Utils;
import src.utils.Constants;
import src.utils.Utils;

import java.util.HashMap;

/**
 * O(N^2)~O(N) 越有序 越快.完全有序的就是O(n)
 * 插入排序  
 * 	//插入排序- 两两互换 每调动一次顺序就互换一次(互换一次，涉及到三次赋值)   10万 6s 11分钟
 * 	//插入排序- 复制         每调动一次顺序就会赋值一次          10万3.5s ;100万  6.5分钟
 * @author xingzhe
 *
 */
public class B_InsertionSort extends AbstractSort {
	public static void SORT_INSERT(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			//找到arr[i]合适的位置。
			// 1 2 3 1(i=1) 每次比较当前和前一个元素
			// 1 2 4 5(i=5) 这种情况只比较一次(5和已排序序列的最大值比较)
			for (int j = i; j >= 1; j--) {
				if (arr[j] >= arr[j - 1]) {
					break;
				} else {
					Utils.swap(arr, j, j - 1);//替换的是相邻两个元素
				}
			}
		}
	}
	public static void SORT_INSERT2(int[] arr){
		SORT_INSERT2(arr,0,arr.length-1);
	}
	public static void SORT_INSERT2(int[] arr,int left,int right){
		for (int i = left+1; i <= right; i++) {
			int doing = arr[i];
			//找到arr[i]合适的位置。
			// 1 2 3 1(i=1) 每次比较当前和前一个元素
			// 1 2 4 5(i=5) 这种情况只比较一次(5和已排序序列的最大值比较)
			int k =-1;//从[0,left]中找到i也就是left+1的合适位置,即大于a[i] 并替换
			for (int j = i-1; j >= 0 ; j--) {
				if (arr[i] < arr[j]) {
					arr[j]=arr[i];
					k=j;//循环下来 最后是第一个大于a[i]的位置，前一个位置
				} else {
					break;
				}
			}
//			//把之前的每次swap优化成一次swap
//			if (k !=-1) {//**** 优化  把之前的每次swap优化成一次swap
//				Utils.swap(arr,i,k);
//			}
			//**** 优化  把之前的每次swap优化成一次swap
			if (k == -1) {//【left,i）中没有小于a【i】的直接拼在最后即可，即不用处理

			}else{
				arr[k+1]=doing;
			}

		}
	}
	public static void main(String[] args) {
		HashMap map= new HashMap<>();
		map.put("chaochao",335676);
		map.put("chaochao1",335676);
		map.put("chaochao",4445);

		int[] arr = Utils.createRandomArr(5,100);
		System.out.println(Utils.printIntSZ(arr));
		System.out.println("---------------------------------");
		B_InsertionSort b_insertionSort = new B_InsertionSort();
		//testReplaceCopy(arr);
		//testCopy(arr);
		b_insertionSort.sort(arr);
		System.out.println(Utils.printIntSZ(arr));
	}

	/**
	 * //插入排序- 两两互换
	 * @param arr
	 */
	private static void testReplaceCopy(int[] arr) {
		//插入排序- 两两互换
		for(int i =1; i<arr.length;i++){
			//从i往前插入; 如果后边这个小于前边的 进行交换
			for(int j =i; j>0 && arr[j] < arr[j-1]; j--){
				//交换
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
			}
		}
	}
	private static void testCopy(int[] arr) {
		//插入排序- 复制
		for (int i = 1; i < arr.length; i++) {
			//找到a[i]的位置
			int m = arr[i];
			int j ;
			for (j = i; (j > 0 && m < arr[j-1]); j--) {
		  //for (j = i; (j > 0 && arr[j] < arr[j-1]); j--) {
				arr[j] = arr[j-1];
			}
			//找到i的位置后,把a[i]原有值 m 赋值过去
			arr[j]= m;
		}
	}

	@Override
	public void sortDetail(int[] arr) {
		//testReplaceCopy(arr);
		//testCopy(arr);
		//SORT_INSERT(arr);
		SORT_INSERT2(arr);
	}
}
