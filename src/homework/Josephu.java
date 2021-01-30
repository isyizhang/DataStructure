package homework;
/*
 * 构建一个单向环形链表
 * 
 * 
 * 
 */


public class Josephu {
	public static void main(String[] args) {
		CircleSingleLinkedList cl = new CircleSingleLinkedList();
		cl.addBoy(41);
		cl.showBoy();
		cl.outBoy(1,3,2);
}
}

//创建一个boy类 表示一个结点
class Boy{
	int num;
	Boy next;
	
	public Boy(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}

class CircleSingleLinkedList{
	//第一个结点   (这种写法是不带头结点的，这个first是包含数据的，算在size中
	Boy first = null;
	int size = 0;
	//添加结点，构建环形链表
	public void addBoy(int n) {
		//
		if(n<1) {
			System.out.println("值不正确");
			return;  //直接结束方法
		}
		Boy curBoy = null;//辅助指针，帮助构建环形链表
		//使用一个循环来创建环形链表
		for(int i = 1;i<=n;i++) {
			Boy boy = new Boy(i);
			if(i == 1) {
				first = boy;
				first.next = first;
				curBoy = first;
				size++;
			}else {
				curBoy.next = boy;
				boy.next = first;
				curBoy = boy;	
				size++;
			}
			
		}
		
	}
	//遍历打印循环链表
	public void showBoy() {
		Boy cur = first;
		if(size == 0) {
		System.out.println("空");
		return;
		}else {
		for(int i=0;i<size;i++) {
			System.out.printf("当前编号为：%d \n",cur.getNum());
			cur = cur.next;
		}
			
		}
	}
	//从start开始数，每次数count下 ，最后剩下end个     （其实这里也可以写参数n代表人数，但我们已经设置了size，就用size（和size一致；不过其实size这个变量可有可无
	public void outBoy(int start,int count,int end) {
		if(start<1 || start>size || first == null) {
			System.out.println("输入参数错误");
		}
		Boy p = first;
		while(p.next != first) {  //把p移动到循环链表最后，也就是first的前一个结点
			p = p.next;
		}
		
		for(int i=0;i<start-1;i++) { //把first移到开始计数的位置，p移到开始计数的位置的前一个；
			first = first.next;
			p = p.next;
		}
		while(size>end) { //判断终止条件 
			for(int j=0;j<count-1;j++) {  //这个for循环是移动要数的步子
				first = first.next;
				p = p.next;
			}
			//循环过后，first指向的结点就是需要出圈的结点
			System.out.printf("出圈的编号为：%d\n", first.num);
			first = first.next;//这两步就是出圈
			p.next = first;
			size--;
		}
		
		System.out.println("最后留下的编号为：");
		this.showBoy();
	
	}
	
	
}


