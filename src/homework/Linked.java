package homework;
/*
 * 1、 根据读入的数据建立单链表，采用头部插入法，直到读入结束标志；
2、 在单链表中查找序号为x的数据元素，如果存在则显示该数据，否则显示不存在。
 */

import java.util.Scanner;

class Node {
	 int data;
	 Node next;
	
	public Node(int data){
		this.data = data;
		this.next = null;
	}
	public Node(int data,Node next) {
		this.data = data;
		this.next = next;
	}	
}

class LinkedList{
	Node head;  //设有头结点
	int size;
	
	//创建空链表
	public LinkedList() {
		this.head = new Node(-1); 
		this.size = 0;
	}
	//创建有一个结点的链表
	public LinkedList(int data) {
		this.head = new Node(-1);
		head.next = new Node(data);
		size=1;
	}
	//头部插入法
	public void addHead(int data) {
		Node N = new Node(data);
		N.next = head.next;
		head.next = N;
		size++;
	}
	
	public LinkedList(int[] arr) {
		this.head = new Node(-1);
		size = 0;
		for(int i=0;i<arr.length;i++) {
			this.addHead(arr[i]);
			size++;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	//返回第i个元素 ；  i=0时返回的是链表中的第一个元素（不包括头结点）
	public int findElem(int i) {
		Node p = head.next;
		int j = 0;
		if(i<0 || i>size-1) System.out.println("不存在");
		while(p.next != null && j<i) {
			p = p.next;
			j++;
		}
		return p.data;
	
	}
	
}


public class Linked {
     
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("请输入数组长度，并以回车结束：");
		int ARRAYLENGTH = scan.nextInt() ;  //指定数组长度
        int a[] = new int[ARRAYLENGTH];
        System.out.println("请输入数组，并以回车结束：");
        for(int i = 0; i < a.length; i++){
            a[i] = scan.nextInt();
        }
        
        LinkedList test = new LinkedList(a);
        System.out.println(test.findElem(2));
     }
}


