package src.immoc.sort;

import src.utils.Utils;

/**
 *	merge 排序 O(nlogn)
 *  在基础版上加了两个优化
 *  	arr[mid] > arr[mid+1]时才需要merge操作；如果左区间的最大值还小于	右区间的最小值 就没必要的
 *  	在划分的子数组长度比较小时 插入排序比归并排序要快。因为插入排序O(N1 n^2)虽然是平方，但前边的系数要比归并排序的小，所以在短数组中 插入反而更快
 *
 * // 1百万 优化的时间时
 */
public class D_MergeSort222 extends AbstractSort{
	 public static void main(String[] args) {
		 int[] a = Utils.createRandomArr(10000*2, 5,true);
		new D_MergeSort222().sort(a);
	 }
	@Override
	public void sortDetail(int[] arr) {
	 	//this.sortDetail_Basic(arr,0,arr.length-1);
	 	this.sortDetail_Better(arr,0,arr.length-1);
	}

	private void sortDetail_Basic(int[] arr, int left, int right) {
		//1 划分
		if (left >= right ) {//跳出递归
			return;
		}
		//int mid=(left+right)/2;
		int mid= left + (left -right)/2;

		sortDetail_Basic(arr,left,mid);
		sortDetail_Basic(arr,mid+1,right);
		//2合并 把arr[left,mid] [mid+1,right]合并
		//其实 仅需 arr[mid] > arr[mid+1]时才需要merge操作；如果左区间的最大值还小于	右区间的最小值 就没必要的
		if (arr[mid] > arr[mid+1]) {// *** 优化1
			merge(arr,left,mid,right);
		}
	}
	private void sortDetail_Better(int[] arr, int left, int right) {
		//1 划分
		if (left >= right ) {//跳出递归
			return;
		}
		if (right- left <4) {
			B_InsertionSort.SORT_INSERT(arr);
		}else{
			//int mid=(left+right)/2;
			int mid= right + (left -right)/2;
			sortDetail_Better(arr,left,mid);
			sortDetail_Better(arr,mid+1,right);
			//2合并 把arr[left,mid] [mid+1,right]合并
			//其实 仅需 arr[mid] > arr[mid+1]时才需要merge操作；如果左区间的最大值还小于	右区间的最小值 就没必要的
			if (arr[mid] > arr[mid+1]) {// *** 优化1
				merge(arr,left,mid,right);
			}
		}
	}
	/*
		把arr[left,mid] [mid+1,right]合并
		left 左边数组的元素
		right 右边数组的元素
	 */
	private void merge(int[] arr, int left, int mid, int right) {
		//需要开辟一个数组空间 存放【left,right】之间排好序的序列
		int[] target=new int[right-left+1];
		//定义三个索引 i j  k 分别表示要[left,mid]中正在比较的索引 [mid+1,right]中正在比较的索引 目标数组的索引
		int i=left;
		int j=mid+1;
		boolean bothHas=true;//左右两个数组都还有元素
		for ( int k=0; k < target.length; k++) {
			//随着 i 和 j的加加操作 得限制其大小
			if (i > mid && j > right) {//左右两个数组都遍历完
				return;
			}
			if ( i > mid) {//左数组遍历完 右边还没有完
				target[k]=arr[j];
				j++;
				bothHas=false;
			}
			if ( j > right) {//右数组遍历完 左边还没有完
				target[k]=arr[i];
				i++;
				bothHas=false;
			}
			if (bothHas) {
				if (arr[i] <= arr[j]) {
					target[k] = arr[i];
					i++;
				}else{
					target[k]=arr[j];
					j++;
				}
			}
		}
		//把 target 数组的元素覆盖在 arr[left ,right]上
		int offset=left;//是两个元素下标的偏移量
		for (int a = left; a <=right ; a++) {
			arr[a]=target[a-offset];
		}
	}
}
