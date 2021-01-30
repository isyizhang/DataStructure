package maze;

public class mazeway {
	
	public static void main(String[] args) {
		
		mazeway mtest = new mazeway();
		mtest.printMaze();
		mtest.MazeWay(5,7,7,1);
		System.out.println();
		mtest.printMaze();
		
	}



//使用栈来实现迷宫寻路
/*思路
 * 1、有一个栈来存放当前位置及其信息
 * 2、栈中元素：迷宫坐标 （该坐标不同的状态需要标记：未走过可走 0 ；已走过 2；四个方向皆不通 3；墙 1；此路通 
 * 3、随着坐标信息的改变，就能打印出迷宫和最终的路径
 * 4、寻路策略：下右上左 （direction 1234），如果此方向通，就一路过去，移动到下一个方块，入栈，并把他们标记为已走过 2；
 * 如果此方向不通，那就换个方向试，如果换方向可以，则入栈；如果四个方向都不通，且栈不为空，把该点标记为不通，出栈；
 * 栈顶元素代表的是当前位置； 
 * 5、终止条件，当前位置等于终点 return；或者没找到 return；
 * 6、需要的方法：入栈、出栈、判断栈空、判断此方向通、打印迷宫
 */

//构建一个栈
class posStack{
	Elem curpos;
    int top = -1;
	Elem[] posStack;
	int maxSize;
	
	posStack(int maxSize){
		this.maxSize = maxSize;
		 posStack = new Elem[maxSize];
	}
	
	boolean isFull() {
		return top == maxSize-1;
	}
	boolean isEmpty() {
		return top == -1;
	}
	
	boolean push(Elem p) {
		if(isFull()) return false;
		else {
		top++;
		posStack[top] = p;
		return true;
		}
	}
	boolean pop() {
		if(isEmpty())return false;
		else {
			Elem p = this.posStack[top];
			maze[p.seat.row][p.seat.col] = 0;
			top--;
			return true;
		}
	}
	//以上是栈的基本操作
	public void show() {
		if(isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for(int i = top;i>=0;i--) {
			Elem p = this.posStack[i];
			posType postion = p.seat;
			System.out.println(postion.row+" "+postion.col);
		}
	}
	
}

class posType{
	int row;
	int col;
	
	posType(int row,int col){
		this.row = row;
		this.col = col;
	}
}
//栈元素的定义
class Elem{
	posType seat;
	int dire;
}

static int[][]maze = new int[][]{
	  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1},
	  {1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1},
	  {1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,1,1},
	  {1,1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,1,1,1,1,0,0,1,1,1},
	  {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,1,1,1},
	  {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
	  {1,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1},
	  {1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1,1},
	  {1,1,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,0,1,1,0,0,0,1,1},
	  {1,1,0,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
	  {1,1,0,0,0,0,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
	  {1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
	  {1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1},
	  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	  
//判断当前位置是否可以走  
  static boolean canMove(posType p) {
	   return maze[p.row][p.col] == 0;    
   }
  
 //根据方向，返回下一个位置的坐标
  posType nextPos(posType p, int dire) {
	  switch(dire) {
	  case 1 : p.row++;break;
	  case 2 : p.col++;break;
	  case 3 : p.row--;break;
	  case 4 : p.col--;break;
	  }
	  return p;
  }
  
//标记当前位置已走过
  void markVistied(posType p) {
	  maze[p.row][p.col] = 2;
  }
  
//标记此位置不通	
   void markCantpass(posType p) {
	   maze[p.row][p.col] = 3;
   }
	
//
  boolean MazeWay(int startrow,int startcol,int endrow,int endcol) {
	  posType start = new posType(startrow,startcol);
	  posType end = new posType(endrow,endcol);
	  posStack mazeStack = new posStack(100);
	  posType curpos = start;
	  do {
		  
		  if(canMove(curpos)) {
			//如果当前位置可走，那就移动到下一个位置
			  markVistied(curpos);
			  Elem e = new Elem();
			  e.seat = curpos;
			  e.dire = 1;
			  mazeStack.push(e);
			  if(curpos == end) {
				  mazeStack.show();
				  return true;
			  }
			  curpos = nextPos(curpos,1);	  
		  }
		  //如果当前位置被标记为不可走（不通or墙or已经走过），就退一步，退一步后，搜寻还没有走过的方向；
		  else {
			  mazeStack.pop();
			  Elem current = mazeStack.posStack[mazeStack.top];
			  while(current.dire == 4 && !mazeStack.isEmpty()) {
				  markCantpass(current.seat);
				  mazeStack.pop();
			  }
			if(current.dire<4) {
				current.dire++;
				mazeStack.push(current);
				curpos = nextPos(current.seat,current.dire);
			}  
			  
		  }
	  }while(!mazeStack.isEmpty());
	  return false;
	  
  }
  
  void printMaze() {
	  for(int i=0;i<maze.length;i++) {
		  for(int j=0;j<maze[0].length;j++) {
			  System.out.print(maze[i][j]+" ");
		  }
		  System.out.println();
	  }
  }
  
   
}




