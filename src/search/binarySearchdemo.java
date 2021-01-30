package search;

public class binarySearchdemo {

	public static void main(String[] args) {
		
		binarySearchdemo demo = new binarySearchdemo();
		int[] arr = new int[] {7,14,18,21,23,29,31,35,38,42,46,49,52};
		System.out.println(demo.binarySearch(arr,22));
		
	
	}

//非递归方法
public int binarySearch(int[] array, int key){
	//代码思路，设置一个low 和 一个high，mid在两者中间，让key和mid比较
	int low = 0;
	int high = array.length-1;
	int mid = (low+high)/2;
	//思考终止条件：也就是什么情况说明找遍了都没有 ！记住，当low>high的时候，就说明找不到了
	//思考过程：如果key小于mid，说明该数应该在mid左边，要把high变为mid-1；反正，把low变成mid+1,再进行比较
	while(low<=high) {
		mid = (low+high)/2;
		if(key<array[mid]) {
			high = mid - 1;
		}else if(key>array[mid]) {
			low = mid+1;
		}else {
			return mid;
			}	
	}
	return -1; //没找到返回-1
}
	
}
