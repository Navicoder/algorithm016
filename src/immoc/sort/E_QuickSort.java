package src.immoc.sort;

import src.utils.Utils;

import java.util.Random;

/**
 * 快速排序：Java http://blog.51cto.com/flyingcat2013/1281614
 * 
 * 块排的递归方式实现
 * 
 * @author skywang
 * @date 2014/03/11
 */
public class E_QuickSort extends AbstractSort{
	private  int cc=0;
	public static void quickSort(int[] arr) {
		qsort(arr, 0, arr.length - 1);
	}
	private static void qsort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int pivot = partition(arr, low, high); // 将数组分为两部分
		qsort(arr, low, pivot - 1); // 递归排序左子数组
		qsort(arr, pivot + 1, high); // 递归排序右子数组
	}
	//int[] arr = { 4, 9, 6, 8, 11, 77, 99, 0, 5, 2, 7 };
	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low]; // 枢轴记录
		while (low < high) {
			while (low < high && arr[high] >= pivot) {
				--high;
			}
			arr[low] = arr[high]; // 交换比枢轴小的记录到左端
			while (low < high && arr[low] <= pivot) {
				++low;
			}
			arr[high] = arr[low]; // 交换比枢轴大的记录到右端
		}
		// 扫描完成，枢轴到位
		arr[low] = pivot;
		// 返回的是枢轴的位置
		return low;
	}

	public static void main(String[] args) {

		int[] arr = Utils.createRandomArr(10,100,true);
		arr= new int[]{4, 9, 6, 8, 11, 77, 99, 0, 5, 2};
		System.out.println("arr初始:" + Utils.printIntSZ(arr));
		System.out.println("==========================================");
		//quickSort(arr);
		new E_QuickSort().sort(arr);
		System.out.println("arr最后:" + Utils.printIntSZ(arr));
	}
	@Override
	public void sortDetail(int[] arr) {
		this.sortDetail(arr,0,arr.length-1);
	}

	//对arr 【left right】进行 快排
	private void sortDetail(int[] arr, int left, int right) {
		if (left >= right || left<0 || right <0) { return ; }
		//选取partition 分割值
		int paviot=getPaviot(arr,left,right);
		//对【left，paviot】【paviot+1，right】 递归划分
		sortDetail(arr,left,paviot-1);
		sortDetail(arr,paviot+1,right);
	}

	/**
	 * 指定一个标准点paviot（一般第一个元素），
	 * 找到标准点paviot合适的位置。使数组左边都大于标准点paviot,右边大于等于标准点paviot
	 *     //从标准点paviot后一个元素到right 遍历，比[标准点paviot小的元素i]和【左数组的后一个角标j+1】替换
	 *     //把标准点paviot置换到合适的位置。
	 * 再用【上边标准点paviot合适的位置】将数组分成两个，递归的执行上述
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 * arr[left,paviot] 都小于arr[Paviot]； [paviot+1,right] 都大于于arr[Paviot]
	 */
	private int getPaviot(int[] arr, int left, int right) {
		//partition
		//定义三个脚标 paviot divide i 分别是 选择的比较标准 分界点 当前遍历的

		//**** 可以优化成随机一个数组元素 TODO but 有代码执行的问题
		//把随机的这个元素和第一个交换位置 就变成和原来一样的逻辑了
		Utils.swap(arr,new Random().nextInt(arr.length-1),left);
		int  v =arr[left];
		int j = left;
		for (int i = left+1; i <= right; i++) {
			if (arr[i] < v) {//i要放在j左边,并把分界点后移一位  TODO *** 性能问题点： 等于 标准点的就被 放在了右数组,会造成退化成O(n^2)
				Utils.swap(arr,j+1,i);
				j++;
			}else{//i要放在j右边[i本来就比j大在右边]
			}
		}
		//把标准值放在合适的位置，至此 左边都比标准值小 右边逗比它大千万不能忘
		Utils.swap(arr,j,left);
		return j;
	}
}