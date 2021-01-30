package LinkedList;
/*
 * 1、 根据读入的数据建立单链表，采用头部插入法，直到读入结束标志；
2、 在单链表中查找序号为x的数据元素，如果存在则显示该数据，否则显示不存在。
 */

//加入dummyHead的操作与重写add方法这一块很妙

class Node<T>{
	 T data;
	 Node<T> next;
	public Node(T data,Node next) {
		this.data = data;
		this.next = next;	
	}
	public Node(T data) {
		this(data,null);
	}
	public Node() {
		this(null,null);
	}
	public String toString() {
		return data.toString();
	}
}

public class LinkedList<T> {
 
	 private Node  dummyHead; //头结点
	 //Node<String> head = new Node<String>("head",null);
	 private int size;  //链表长度
	
	//头结点.next,才是链表中的第一个结点；
	//创建一个空链表
	public LinkedList() {
		dummyHead = new Node();
		size = 0;//头结点不计入size
	}
	//public LinkedList(T data) {
		//Node<String> head = new Node<String>("head",null);
		//head.next = new Node(data);
		//size = 1;
	//}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size ==  0;
	}
	public void addFirst(T data) {
		add(0,data);
	}
	public void add(int index,T data) {
		//参数校验
		if(index<0|| index>size)
			throw new IllegalArgumentException("Add failed, Illegal index.");
		Node prev = dummyHead;
		//遍历出index前一个Node节点
		//这里把index-1改为index是因为多了一个虚拟节点，就不需要-1操作了
		for(int i=0;i<index;i++) {
			prev = prev.next;
		}
		//Node node = new Node(e);
		//node.next=prev.next;
		//prev.next = node;
		//上面三句可以用下面一句解决
		prev.next = new Node(data,prev.next);
		size++;
	}
	
	public void addLast(T data) {
		add(size,data);
	}

	
	//头插法
/*
 * public void addHead(T data) {
 
		Node<T> N = new Node<T>(data);
		if(head.next == null) {
			head.next = N;
		}else{
			N.next = head.next;  
			head.next = N;  //空指针异常
		}
		 //head.next = new Node<T>(data,head.next);
		size++;
	}
	//返回第i个元素 ；  i=0时返回的是链表中的第一个元素（不包括头结点）
*/
	public T findElem(int i) {
			Node<T> p = dummyHead.next;
			int j = 0;
			if(i<0 || i>size-1) System.out.println("不存在");
			while(p.next != null && j<i) {
				p = p.next;
				j++;
			}
		return (T) p.data;
		
		}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              

class linktest{
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.addFirst(2);
		l.addFirst("1998");
		l.addFirst("d");
		l.addFirst(888);
		l.addLast(100);
		System.out.println(l.findElem(4));
	}
}

