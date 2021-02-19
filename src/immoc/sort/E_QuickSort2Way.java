package src.immoc.sort;

import src.utils.Utils;

import java.util.Random;

/**
 * 快速排序：单路快排对于有序列表和有大量重复值的会造成划分成两个极不平衡的数组，进而退化成O(n^2)的算法
 * 
 * 块排的递归方式实现
 * 
 * @author skywang
 * @date 2014/03/11
 */
public class E_QuickSort2Way extends AbstractSort{

	public static void main(String[] args) {
		//int[] arr = Utils.createRandomArr(20,10000,false);
		int[] arr = Utils.createRandomArr(10,100,false);
		int[] arr2 =Utils.copyArr(arr);
		System.out.println("arr:" + Utils.printIntSZ(arr));
		System.out.println("==========================================");
		//quickSort(arr);
		new E_QuickSort2Way().sort(arr);
		System.out.println("arr:" + Utils.printIntSZ(arr));
	}
	@Override
	public void sortDetail(int[] arr) {
		this.sortDetail(arr,0,arr.length-1);
	}

	//对arr 【left right】进行 双路块排

	private void sortDetail(int[] arr, int left, int right) {
		if (left >= right || left<0 || right <0) { return ; }
		//选取partition 分割值
		int paviot=getPaviot(arr,left,right);
		//对【left，paviot】【paviot+1，right】 递归划分
		sortDetail(arr,left,paviot-1);
		sortDetail(arr,paviot+1,right);
	}
    /**
     * 指定一个标准点paviot（一般第一个元素），值为v
	 * 定义两个脚标 i j 表示 左边数组(左边<=v)往右递归时遍历的元素， 右边数组(右边  大于等于v)往左递归时遍历的元素
	 * i++ j--两路遍历
	 * 		对于i 找到比标准值大的或者等于的
	 * 		对于j 找到比标准值小的或者等于的
	 * 直至 i和j碰头了
	 * @param arr
	 * @param left
     * @param right
     * @return
     */
	private int getPaviot(int[] arr, int left, int right) {
		int paviot=new Random().nextInt(arr.length-1);
		int paviotVal=arr[paviot];
		int i=left+1,j=right;//定义遍历的两路元素
		while(true){
			while (i < j && arr[i] < paviotVal){
				i++;
			}
			while (j > i && arr[j] > paviotVal){
				j--;
			}
			if (i >=j || i> right || j < left) {
				break;
			}
			Utils.swap(arr,i,j);
			//怎么保证的 等于的 在两个上边
		}
		//i是标准值该在的位置
		Utils.swap(arr,i,paviot);
		return i;
	}
}