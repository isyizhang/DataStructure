package stack;

public class stackTest {
	public static void main(String[] args) {
		ArrayStack st = new ArrayStack(5);
		st.push(4);
		st.push(55);
		st.push(7);
		st.push(8);
		st.pop();
		st.show();
	}

}

//用数组模拟栈
class ArrayStack{
	private int top = -1;  //这里把top设为-1，好处就是top指的就是栈顶元素；ppt上top=0，也就说int【top-1】才是栈顶元素；
	private int stacksize;//初始分配的最大容量
	private int[] stack;//用于模拟栈的数组
	
	//构造一个空栈
	public ArrayStack(int stacksize) {
		this.stacksize = stacksize;
		stack = new int[this.stacksize];
	}
	//判断是否为空栈
	public boolean isEmpty() {
		return top == -1;
	}
	//判断是否栈满
	public boolean isFull() {
		return top == stacksize-1;
	}
	//入栈
	public void push(int value) {
		if(isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top]= value;
	}
	//出栈
	public int pop() {
		if(isEmpty()) {
			System.out.println("栈空");
			throw new RuntimeException("栈空，没有数据~"); //这里不能直接写return，因为函数是int，如果写return只能返回int；
		}
		int value = stack[top];
		top--;
		return value;	
	}
	//遍历栈，从栈顶开始
	public void show() {
		if(isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for(int i = top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
}