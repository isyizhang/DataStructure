package stack;

//用数组实现队列
public class QueueTest {
	public static void main(String[] args) {
		SeQueue q = new SeQueue(4);
		q.inQueue(23);
		q.inQueue(4);
		q.inQueue(77);
		q.show();
		q.inQueue(8);
		q.outQueue();
		q.outQueue();
		q.show();
		q.getFront();
		System.out.println(q.length());
		q.inQueue(1998);
		q.inQueue(10);
		q.inQueue(18); //此时队列已满 (只能放3个）
		q.show();
	}

}

class SeQueue{
	int maxsize; //队列最大容量
	int front;//队头 指向队列的第一个元素
	int rear;//队尾 rear 指向队列的最后一个元素的后一个位置. （希望空出一个空间做为约定.
	int[] queue;
	
	//构建一个空队列
	public SeQueue(int maxsize){
	    queue = new int[maxsize];
		this.maxsize = maxsize;
	}
	//判断队空
	public boolean isEmpty() {
		return rear == front;
	}
	//判断队满  为了与队空区分 队满的条件其实是maxsize-1
	public boolean isFull() {
		return (rear+1)%maxsize == front;
	}
	//返回当前队列有效元素个数
	public int length() {
		return (rear-front+maxsize)%maxsize;
	}
	//入队 在队尾添加元素
	public void inQueue(int data) {
		if(isFull()) {
			System.out.println("队列已满");
			return ; //队满 这里用return是为了终止方法
		}
		queue[rear] = data;
		rear = (rear+1)%maxsize;
	}
	//出队 从队头出队
	public boolean outQueue() {
		if(isEmpty()) {
			System.out.println("队列已空");
			return false;
		}
		int data = queue[front];
		System.out.println(data);
		front = (front+1)%maxsize;
		return true;
	}
	//得到队头数据
	public void getFront() {
		if(isEmpty()) System.out.println("队空");
		else System.out.println(queue[front]);
	}
	//遍历队
	public void show() {
		if(isEmpty()) {
			System.out.println("队空");
			return;
		}
		//要从队头开始遍历，循环的次数为队的长度
		for(int i=front;i<front+length();i++) {
			//需要取模
			System.out.printf("queue[%d]:%d",i%maxsize,queue[i%maxsize]); 
			System.out.println();
		}
		
	}
	
	
}