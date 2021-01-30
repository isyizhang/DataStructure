package LinkedList;

//代码优化的点
public class SLList {
	
	//内部类 nested class
	//static关键字的使用
	private static class IntNode{
		
		public int item;
		public IntNode next;
		public IntNode(int i,IntNode n) {
			item = i;
			next = n;
		}
		
	}
	
	//把节点改为private属性
	private IntNode first;
	//我们如何能够快速得到size，而不需要遍历一遍链表---设置一个size属性记录
	private int size;
	
	//空链表构造器
	public SLList() {
		first = null; //这代表第一个结点里什么都没有，数据没有指针没有；
		size = 0;
	}
	
	//构造器
	public SLList(int x){
		first = new IntNode(x,null);
		size = 1;
	}	
	
	//头插法的思路，java的封装性
	public void addFirst(int x) {
		
		//头插法没有是否要判断为空表的问题
		
		first = new IntNode(x,first);
		size++;
	}
	
	//得到第一个节点中的数据
	public int getFirst() {
		
		return first.item;
		
	}
	
	
	//尾插法
	//思路也是设置设置一个指针，一直往后移，直达移到最后一个结点；
	public void addLast(int x) {
		
		IntNode p = first;
		//尾插法的问题是，当链表为空时（也就是first就是null，p.next==null.next 的就会报空指针异常的错）
		//空表时，把插入的新结点作为第一个结点；
		if (p==null) {
			first = new IntNode(x,null);
		}else {
		while(p.next != null) {
			p = p.next;
		}	 
		//在最后一个节点的下一个，new一个新的节点
		p.next = new IntNode(x,null);
		}
		size++;
	}
	//怎么计算一个size，因为java没有指针p，你自己写会发现这非常困难，
	//我们常见的作法是需要给它一个指针p（其实就是给他一个起始的node）
	//实际上你想象一个有五个节点的链表，如果你指定的变量（即开始的节点）是第二个节点，你算出来的size就是4个，这是链表的特点你可以揣摩一下
	private static int size(IntNode p) {
		
		if (p.next == null) {
			return 1;
		}
		return 1+size(p.next);
	}
	//在公开给user使用的method中，我们直接return我们写好的内部方法，这样就固定了我们node的起始位置一定是头节点；
	public int size() {
		return size(first);
	}
	
	public int fastsize() {
		return size;
	}

}

class Stest{
	
	public static void main(String[] args) {
		
		SLList sl = new SLList();
		sl.addLast(4);
		sl.addLast(5);
		sl.addLast(7);
		sl.addFirst(99);
		sl.addFirst(777);
		System.out.println(sl.getFirst());
		System.out.println(sl.size());
		System.out.println(sl.fastsize());
	}
}



