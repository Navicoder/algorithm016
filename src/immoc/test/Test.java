package src.immoc.test;

import src.utils.Constants;
import src.utils.Utils;

import java.util.Random;

public class Test {
	public static void printGC(){
		long maxMemory = Runtime.getRuntime().maxMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("虚拟机中试图使用的最大的内存是（最大分配）：" + maxMemory / (double)1024 / 1024 + "MB");
		System.out.println("虚拟机的总内存(初始分配)："+totalMemory/(double)1024/1024+"MB");
		System.out.println("虚拟机的空闲内存(freeMemory)："+freeMemory/(double)1024/1024+"MB");
		System.out.println(new Random().nextInt(100));
	}
	public static void main(String[] args) {
		//printGC();
//		useXOR(5,6);
		test();

	}

	public static void useXOR(int a, int b) {
		System.out.println(a ^ b ^ b);
		System.out.println(a ^ (b ^ b));
		System.out.println(a ^ b ^ a);

//		a = a ^ b; // 0101 ^ 0011 = 0110
//		b = a ^ b; // 0110 ^ 0011 = 0101
//		a = a ^ b; // 0110 ^ 0101 = 0011
		System.out.println("a==" + a + ", b==" + b);
	}

	public static void test(){
		int a =-1987;
		int b =1191;
		int avg=0;
		int aa=a^b;
		if((a^b)<0) {
			System.out.println(111);
			System.out.println(avg=(a+b)/2);
			System.out.println( b + (a - b) / 2);
		}else {
			if(a>=b) {

				System.out.println(222);
			}
			else
				avg=a+(b-a)/2;
		}
		System.out.println("平均数是："+avg);
	}

}
