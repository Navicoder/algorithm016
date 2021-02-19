package src.immoc.sort;

import src.utils.Utils;

/**
 * 快速排序：Java http://blog.51cto.com/flyingcat2013/1281614
 * 
 * 单路快排
 * 		1 选出一个基准点，一次遍历使得 改点之后的都比改值大，之前的都比该值小
 * 		2 可能会出现左右两个树极度不平衡
 * 			2-1 	刚开始是选择每个子数组的第一个元素作为基准点。但可能会退化成O^2的排序。【所以随机选取一个作为基准点】
 * 			2-2		如果是近乎有序的数组或者有大量重复的值 可能会出现左右两个树极度不平衡	【用两路快排或三路】
 * 	双路快排
 * 		1 选出两个基准点 i j  把<= p的放在i前边 >= p的放在j后边。这样就把等于P的军分到了两个子数组中
 * 		2 但是如果有很多等于p的话 ，本可以不处理的，会多做了无用功
 *
 * 	三路快排
 * 		1 选出三个角标 i k j 把把< p的放在i前边; > p的放在j后边。把=p的放在[i+1,k] 这样等于p的就不用处理了
 *
 *
 * 
 * @author skywang
 * @date 2014/03/11
 */
public class EE_QuickSort3Way extends AbstractSort{


	@Override
	public void sortDetail(int[] arr) {
		sortDetail(arr,0,arr.length-1);
	}

	private void sortDetail(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
//		int[] p = partition(arr,left,right);//划分
//		if (p[0]==-1) {
//			return;
//		}
//		sortDetail(arr,left,p[0]-1);
//		sortDetail(arr,p[1],right);


		partition2(arr,left,right);
	}

	//三路块排 分成 <V; ==V; >V的三个区域
	//定义的变量 left p pVal lt gt right

	//arr[left,lt] <V
	//arr[lt+1,,gt-1] ==V
	//arr[gt,,right] > V
	private int[] partition(int[] arr, int left, int right) {
		int p =left;
		int pVal=arr[left];
		int lt=left;
		int gt=right+1;//加一是因为 i能要触及arr[right] 替换的时候 是找的gt-1 所以起始 需要加1
		for (int i = left+1; i <=right ; i++) {
			if (lt >gt || lt > right ||gt <left ) {
				return new int[]{-1};
			}
			if (arr[i] == pVal) {
				//不用处理 i++就把当前元素归到== 里边了
			}else if (arr[i] < pVal){
				Utils.swap(arr,lt+1,i);
				lt++;
			}else if (arr[i] > pVal){
				Utils.swap(arr,gt-1,i);
				gt--;
				i--;//把gt前一个元素换到i位置处 但是它还没有参与比较，遍历时1++ 所以这里先减掉
			}
		}
		Utils.swap(arr,p,lt);
		return new int[]{lt,gt};
	}
	private void partition2(int[] arr, int left, int right) {
		int p =left;
		int pVal=arr[left];
		int lt=left;
		int gt=right+1;//加一是因为 i能要触及arr[right] 替换的时候 是找的gt-1 所以起始 需要加1
		int i=left;

		while (lt<gt){
			if (arr[i] == pVal) {
				//不用处理 i++就把当前元素归到== 里边了
				i++;
			}else if (arr[i] < pVal){
				Utils.swap(arr,lt+1,i);
				lt++;
				i++;
			}else if (arr[i] > pVal){
				Utils.swap(arr,gt-1,i);
				gt--;
			}
			partition2(arr,left,lt);
			partition2(arr,gt,right);

		}
	}
	public static void main(String[] args) {
		int[] arr = Utils.createRandomArr(5, 100,false);
		//arr = new int[]{10,10,10,10,10,10};
		System.out.println(Utils.printIntSZ(arr));
		new EE_QuickSort3Way().sort(arr);
		System.out.println(Utils.printIntSZ(arr));


	}

}