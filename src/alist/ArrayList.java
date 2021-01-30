package alist;

import java.lang.*;

public class ArrayList<Elem> {
	
	private int length;//最大的容量
	private int size;//当前元素个数
	private Elem[] alist;//数据数组
	
	//顺序表构造器
	public ArrayList(int length) {
		alist = (Elem[]) new Object[length];
		this.length = length;
		size = 0;			
	}
	
	//得到当前顺序表中元素个数
	public int getSize() {
		return this.size;
	}
	
	//判断顺序表是否为空
	public boolean isEmpty() {
		if(size == 0) 
			return true;
     else
			return false;	
	}
	
	//得到index为i的元素
	public Elem get(int i) {
		if(i<0 || i>size-1)
			return null;
		else 
			return alist[i];
	}
	//将元素添加到末尾
	
	
	
	//插入元素到index为i的位置
	public boolean insert(int i,Elem e) {
		if(size==length) {
			System.out.println("顺序表已满");
			return false;
		}
		if(i<0||i>size) {
			System.out.println("插入位置不合法");
			return false;
		}
		for(int j=size-1;j>=i;j--) {
			alist[j+1]=alist[j];
		}
		alist[i]=e;
		size++;
		return false;			
	}
	
	//查找元素e所在的位置
	public int find(Elem e) {
		for(int i=0;i<size;i++) {
			if(alist[i]==e) { return i;}
			}
		 return -1;
						
	}
	//删除index为i的元素
	public boolean remove(int i) {
		if(i<0||i>size)return false;
		for(int j=i+1;j<size;j++) {
			alist[j-1]=alist[j];
		}
		size--;
		return true;
	}
	//输出顺序表
	public void display() {
		if(size==0) {
			System.out.println("size:0");
		}
		for(int i=0;i<size;i++) {
			System.out.print(alist[i]+"\t");
		}
		System.out.println();
	}
	
	
	
}
