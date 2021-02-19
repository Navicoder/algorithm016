package src.immoc.sort;

import src.utils.Utils;

/**
 * 快速排序：Java http://blog.51cto.com/flyingcat2013/1281614
 * 
 * 块排的递归方式实现
 * 
 * @author skywang
 * @date 2014/03/11
 */
public class EE_QuickSort2Way extends AbstractSort{


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

	//两路块排 使用两个脚标 i j  分界点k
	// i--->   <---j  遍历路上发现
		// 对于i比标准值小的 收到小于标准值的阵营来，就是swap[++k]=arr[i] 能是arr[++k]=arr[j] 因为++k位置的元素就被覆盖了
			//大于标准值的，不用处理 直接i++
		// 对于j比标准值大的 收到大于标准值的阵营来，【不用处理 直接j++】
			//小于标准值的，swap(++k,j) 不能是arr[++k]=arr[j] 因为++k位置的元素就被覆盖了
	//把 i j的元素交换
	//知道 i j碰头
	private int partition(int[] arr, int left, int right) {
		int p =left;
		int pVal=arr[left];
		//int k =left;//两路里用不着分界点了
		int i=left+1;
		int j=right;
		while(true){//while（i<j）没有意义 其实就是比较了一次i j 的初始值而已
			while (i<=right && arr[i] < pVal && i<=j) i++;
			while (j>=left+1 && arr[j] > pVal && j>=i) j--;
			if (i>=j){
				break;
			}
			i= i==right+1?right:i;

			Utils.swap(arr,i,j);
			//继续找元素
			i++;
			j--;
		}

		//排好序后 从前往后看 i 是第一个大于等于pVal的元素
		//排好序后 从后往前看 j 是第一个小于等于pVal的元素，即最后一个小于等于pVal的元素。p在小于的区域里 所以只能和j替换
		Utils.swap(arr,p,j);
		return j;
	}

	public static void main(String[] args) {
		int[] arr = Utils.createRandomArr(5, 100,false);
		arr = new int[]{10,10,10,10,10,10};
		System.out.println(Utils.printIntSZ(arr));
		new EE_QuickSort2Way().sort(arr);
		System.out.println(Utils.printIntSZ(arr));


	}

}