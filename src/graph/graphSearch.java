package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//用邻接矩阵来存储图并进行遍历
	//我们需要：一个数组来存储顶点信息，一个二维数组来表示图，行表示出度，列表示入度
class graph{
		public String[] vertexs; //存放顶点信息 用数组或者arraylist都可以
		int[][] adjMatrix;//邻接矩阵
		int vertexnum,arcnum;//顶点个数和边的个数
		//boolean[] visited;//标记是否访问过
		
		//图的构造器,给的参数是顶点数量
		public graph(int num) {
			//vertexs = new String[num];
			adjMatrix = new int[num][num];
			vertexnum = num;
		}
		
		//添加顶点操作  算了 咱们练习就不需要写这么详细，自己手动加就完事了
		//public void insertVertexs(String) {
			
		//}
		//添加边的操作   这是有向图的情况
		public void addArc(int tail,int head,int weight) {
			//在没有真正权值的情况下，这个weight就设定为1
			adjMatrix[tail][head] = weight;
			adjMatrix[head][tail] = weight;//这是无向图的情况，视情况要不要去掉这句
			arcnum++;
		}
		//打印邻接矩阵
		public void showMatrix() {
			System.out.println(Arrays.toString(vertexs));
			for(int i =0;i<adjMatrix.length;i++) {
				for(int j=0;j<adjMatrix[i].length;j++) {
					System.out.print(adjMatrix[i][j]+" ");
				}
				System.out.println();
			}
		}
		//对图的深度优先遍历：为了避免非连通图的情况，要对每一个结点都进行一遍dfs
		public void dfsTraverse() {
			boolean[] visited = new boolean[vertexnum];  //在这里new一个数组是更合理的，如果new在外面，就只能遍历一次了，然后把这个数组传给dfs
			for(int i=0;i<vertexnum;i++) {
				if(visited[i]==false) {
					dfs(i,visited);
				}
			}
		}
		
		//深度优先遍历算法,v 是起始结点，下标从0开始
		//遍历思路：访问当前结点，标记为以访问，再去访问当前结点的下一个结点，对其进行dfs
		void dfs(int v,boolean[] visited) {
			visited[v] = true;
			System.out.print(vertexs[v]+">-");//
			for(int j=0;j<vertexnum;j++) {
				if(adjMatrix[v][j]!=0 && visited[j]==false) {
					dfs(j,visited);
				}
			}
			
		}
		
		void bfs(int i,boolean[] visited) {
			int u ; // 表示队列的头结点对应下标
			LinkedList<Integer> queue = new LinkedList<Integer>(); //记录访问顺序
			visited[i] = true; //标记为已访问
			System.out.print(vertexs[i]+" "); 
			queue.addLast(i); //入队
			while(!queue.isEmpty()) {
				u = queue.removeFirst(); //得到队头，对其下面的邻接点进行访问
				for(int w=0;w<vertexnum;w++) { //一开始访问的就是i顶点的邻接点
					if(!visited[w] && adjMatrix[u][w] != 0) {
						System.out.print(vertexs[w]+" ");
						visited[w] = true; 
						queue.addLast(w); 
					}
				}//for循环结束了，首轮代表i的邻接点就找完了，
				//那么接下来要找的还是队头的，还是进入这个while循环里，出队的就是队头，对队头寻找它的邻接结点；
				//跳出while循环是所有都出队了，这就代表着都找完一遍
			
			}
			
		}
		
		//这还是为了防止出现非连通图，对每一个结点都进行一次bfs
		void bfsTraverse() {
			boolean[] visited = new boolean[vertexnum];
			for(int i=0;i<vertexnum;i++) {
				if(!visited[i])
				bfs(i,visited);
			}
		}
		
	}

public class graphSearch {	
	public static void main(String[] args) {
		graph ppt = new graph(8);
		ppt.vertexs = new String[]{"v1","v2","v3","v4","v5","v6","v7","v8"};
		ppt.addArc(0,1,1);
		ppt.addArc(0,2,1); //注释掉这一行就变成非连通图了，广度优先的结果会有区别，可以自己试试看；
		ppt.addArc(1,3,1);
		ppt.addArc(1,4,1);
		ppt.addArc(2,5,1);
		ppt.addArc(2,6,1);
		ppt.addArc(3,7,1);
		ppt.addArc(4,7,1);
		ppt.addArc(5,6,1);
		ppt.showMatrix();
		ppt.dfsTraverse();
		System.out.println();
		ppt.bfsTraverse();
		
	}
	

}
