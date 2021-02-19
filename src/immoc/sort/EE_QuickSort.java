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
public class EE_QuickSort extends AbstractSort{


	@Override
	public void sortDetail(int[] arr) {
		sortDetail(arr,0,arr.length-1);
	}

	private void sortDetail(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int p = partition(arr,left,right);//划分
		sortDetail(arr,left,p-1);
		sortDetail(arr,p+1,right);
	}

	//返回p使得 arr[left,p]都小于标准值，arr[p+1,right]都大于标准值（还有等于）
	private int partition(int[] arr, int left, int right) {
		Utils.swap(arr,left,(int)(Math.random()*(right-left+1))+left);

		int p =left;
		int pVal=arr[left];
		int j =left;//分界点
		for (int i = left+1; i <=right ; i++) {
			if (arr[i] < pVal) {
				j++;
				Utils.swap(arr,i,j);
			}
		}
		Utils.swap(arr,p,j);
		return j;
	}

	public static void main(String[] args) {
		int[] arr = Utils.createRandomArr(10000*2, 5,true);
		new EE_QuickSort().sort(arr);
		System.out.println(Utils.printIntSZ(arr));


	}

}