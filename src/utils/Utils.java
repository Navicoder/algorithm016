package src.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Utils {
	public static int[] arr = {1,8,4,3,4,6,8,9,33,5,6,2,5,753};

	public static <T> T[] swap(T t1, T t2){
		return null;
		
	}
	/*
	角标
	 */
	public static void swap(int[] arr,int t1, int t2){
		int temp = arr[t2];
		arr[t2] = arr[t1];
		arr[t1] = temp;
	}
	/**
	 * 产生一个size大小的、数组分布范围为0-range的数组
	 * @param size
	 * @param range
	 * @return
	 */
	public static int[] createRandomArr(int size,int range,boolean hasFeed){
		Random r;
		if (hasFeed) {
			r = new Random(100l);
		}else{
			r = new Random();
		}
		int[] arr = new int[size];
		for(int j =0; j<size;j++){
			arr[j] = r.nextInt(range);
		}
		return arr;
	}
	public static int[] createRandomArr(int size,int range){
		return createRandomArr(size,range,false);
	}
	public static int[] createNearlyOrderArr(int size,int range,boolean flag){
		int[] arr = new int[size];
		for(int j =0; j<size;j++){
			arr[j] = j;
		}
		return arr;
	}
	public static int[] createNearlyOrderArr(int size,int range){
		return createNearlyOrderArr(size,range,false);
	}

	public static String printIntSZ(int[] i){
		StringBuffer sb = new StringBuffer();

		for (int j = 0; j < i.length; j++) {
			sb.append(i[j]).append(",");
		}
		sb.delete(sb.lastIndexOf(","), sb.length());
		return sb.toString();
	}
	
	//字符串写到文件中
	public static void writeToFile(String filePath,String fileName,Object something){
		if (!filePath.endsWith("/")) {
			filePath = filePath+"/";
		}
		FileOutputStream out = null;
		PrintWriter pw = null;
		try {
			File file = new File(filePath);
			if (!file.exists() ||!file.isDirectory()) {
				file.mkdirs();
			}
			File file2 = new File(filePath+fileName);
/*			out = new FileOutputStream(file2);
			out.write(something.getBytes());
			
			System.out.println("写入成功："+filePath+fileName);*/
			
			FileWriter fileWriter = new FileWriter(file2, true);
			pw = new PrintWriter(fileWriter);
			pw.println(something);
			//pw.println("\n");
			pw.flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (pw != null) {
				try {
					pw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	
	
	public static void main(String[] args) {
		writeToFile("D:\\immoc.test", "sunfa.txt", "6666666666666");
	}

	public static int[] copyArr(int[] arr) {
		int[] n = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			n[i]=arr[i];
		}
		return n;
	}
}
