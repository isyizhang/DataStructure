package LinkedList;

public class IntListtest {
       public static void main(String[] args) {

   		//这就是自己造的一个链表
   		
   		//自己想象一下下面这些代码会变成什么样
   		//首先new了一个box，第一格存数据10，第二格存了个null
   		IntList L = new IntList(10,null);
   		//另一个box，第一格存5，第二格存的是L，也就是前一个box的地址
   		L = new IntList(5,L);
   		//继续链接;其实这就是头插法的思路
   		L = new IntList(6,L);
   		L = new IntList(7,L);
   		L = new IntList(4,L);
   		L = new IntList(5,L);
   		
   		System.out.println(L.sizer());
   		System.out.println(L.size());
   		System.out.println(L.get(7));
	
	
}
}


class IntList {
	
	public int first;
	public IntList rest;//存的引用类型--实际就是一个地址
	
	public IntList(int f,IntList r) {
		first = f;
		rest = r;
	}
	
	//用iterative来实现size计算
	public int size() {
		IntList p = this;
		int sum = 0;
		while(p != null) {
			sum++;
			p = p.rest;
		}
		return sum;
	}
	
	//使用递归来实现 计算当前链表的节点数
	public int sizer() {
		
		if(rest == null) {
			return 1;
		}
		return 1+this.rest.sizer();
	}
	
	//得到第i个元素的值；
	public int get(int i) {
		
		IntList p = this;
		int j = 0;	
		while(p.rest != null && j<i) {
			p = p.rest;	
			j++;
		}
		if(p.rest != null) {
		return p.first;}
		return -1;
	}

	//使用递归来得到第i个元素的值；
	public int getr(int i) {
		if(i == 0) {
			return first;
		}
		return rest.getr(i-1);
	}
	
}

