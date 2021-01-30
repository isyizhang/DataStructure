package sort;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String[] args) {
		InsertSort demo = new InsertSort();
		int[] arr1 = new int[] {0,47,38,65,97,13,27,47};//这种是设置了哨兵的，也就是说arr[0]没有意义；看排序的最后结果要从第二位看起；
		demo.insertsort(arr1,7);
		System.out.println(Arrays.toString(arr1));
		
	}
	
	public void insertsort(int[] arr,int n) { //n是代表元素个数，在设置哨兵的情况下，是length-1；
		int i,j;
		for(i=2;i<=n;i++) {
			arr[0]=arr[i];
			for(j=i-1;arr[0]<arr[j];j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1] = arr[0];
		}
	}

}

