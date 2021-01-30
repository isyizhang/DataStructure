package LinkedList;




public class IntNode {
	
	public int item;
	public IntNode next;
	
	public IntNode(int i,IntNode n) {
		item = i;
		next = n;
	}

}



/*
 * 改造前的代码
  class Sllist{
	
	public IntNode first;
	
	public SLList(int x){
		first = new IntNode(x,null);
	}	
	
	//头插法的思路，java的封装性
	public void addFirst(int x) {
		
		first = new IntNode(x,first);
		
	}
	
	//得到第一个节点中的数据
	public int getFirst() {
		
		return first.item;
		
	}
	
	
}




class SListTest{
	
	public static void main(String[] args) {
		
		SLList L = new SLList(10);
		//在封装的方法下，变得更容易使用，其实深层原理是一样的；
		L.addFirst(10);
		L.addFirst(9);
		L.addFirst(1888);
		
	}
	
	
}
*/