package src.immoc.sort;

import src.utils.Constants;
import src.utils.Utils;


import java.util.concurrent.atomic.AtomicLong;

/**
 排序 只是一些打印信息 - 模板方法设计模式

 log (n^2)
 * 选择排序每次都会全遍历；插入排序可以避免每次全遍历，特别是对有顺序的序列，越有序 越快，甚至比nlogn的还快
 */
public abstract class AbstractSort {
	public abstract void sortDetail(int[] arr);

	public void sort(int[] arr){
		writeBeforeSortIfBigData(arr);
		long start=new Long(System.currentTimeMillis());
		sortDetail(arr);
		long l2 = System.currentTimeMillis() - start;
		writeAfterSortIfBigData(arr,start);


	}

	private void writeAfterSortIfBigData(int[] arr,long l2) {
		if (arr.length>10000 ) {
			Utils.writeToFile(Constants.SUNAFA_PATH, Constants.SUNAFA_FILENAME, "排序耗时"+formatTime(System.currentTimeMillis()-l2)+"\n");
		}else{
			Utils.writeToFile(Constants.SUNAFA_PATH, Constants.SUNAFA_FILENAME, "排序耗时"+formatTime(System.currentTimeMillis()-l2)+"\n 排序后"+Utils.printIntSZ(arr));

		}
	}

	protected  void writeBeforeSortIfBigData(int[] arr){
		if (arr.length >10000){
			Utils.writeToFile(Constants.SUNAFA_PATH, Constants.SUNAFA_FILENAME, "==========================\n"+this.getClass().getName()+"\n初始数组size:"+arr.length+"\n");
		}else{
			Utils.writeToFile(Constants.SUNAFA_PATH, Constants.SUNAFA_FILENAME, "==========================\n"+this.getClass().getName()+"\n初始数组size:"+arr.length+"\n"+"初始数组:"+Utils.printIntSZ(arr));
		}
	}
	public static String formatTime(long timeDuring){
		int h=0;
		int m=0;
		int s=0;
		int ms=0;
		ms= (int) (timeDuring % 1000);
		s= (int) (timeDuring/1000 % 60);
		m= (int) (timeDuring/1000/60 % 60);
		h= (int) (timeDuring/1000/60/60 % 60);

		return h+"H,"+m+"M,"+s+"s,"+ms+"MS";
	}

	public static void main(String[] args) {
		System.out.println(formatTime(3600*1000-1));
	}


}
