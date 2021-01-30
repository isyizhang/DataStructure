package graphmst;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Edge{
	char u;
	char v;
	int weight;
	
	public Edge(char u,char v,int weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
}

public class kruskal张怡2017201773 {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int[][] map = new int[][] { //用的例子是一个无向图
			{0,2,6,MAX,1},
			{2,0,5,4,MAX},
			{6,5,0,10,1},
			{MAX,4,10,0,2},
			{1,MAX,1,2,0}
		};
		char c[] = new char[] {'A','B','C','D','E'};
		kruscal(map,c);

	}
	static ArrayList<Edge> getedges(int[][]graph, char[]c) {//获得图的所有边
		ArrayList<Edge> edges = new ArrayList<>();
		for(int i=0;i < graph.length;i++) {
			for(int j = 0;j < graph.length;j++) {
				if(graph[i][j]!=MAX) {
					Edge edge = new Edge(c[i], c[j], graph[i][j]);
					edges.add(edge);
				}
			}
		}
		return edges;
	}
	static void sort(ArrayList<Edge>edges) {//按照权重对边排序
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge edge1, Edge edge2) {
                return edge1.weight-edge2.weight;
            }
		});
	}
	public static void kruscal(int[][]graph,char[]c) {
		ArrayList<Edge> edges = new ArrayList<>();
		edges = getedges(graph,c);
		sort(edges);
		
		ArrayList<Edge> minedges = new ArrayList<>();//保存最小生成树的边
		int[]u2v = new int[graph.length];//保存已有最小生成树中每个顶点的最短边的邻接顶点
		
		for(int i=0;i<edges.size();i++) {
			int p1 = getIndex(c, edges.get(i).u);//获得该边的起点
			int p2 = getIndex(c, edges.get(i).v);//获得该边的终点
			//System.out.println(edges.get(i).u);
			int m = getEnd(u2v,p1);//获得已有最小生成树中该边起点的终点
			int n = getEnd(u2v,p2);//获得已有最小生成树中该边终点的终点
			
			if(m!=n) {//不是回路，则把边添加到minedges
				u2v[m] = n;
				minedges.add(edges.get(i));
				System.out.println(edges.get(i).u + "-----" + edges.get(i).v + ":" + edges.get(i).weight);
			}
			
		}		
	}
	static int getIndex(char[]c, char ch) {
		int i = 0;
		for (; i < c.length; i++)
			if (c[i] == ch)
				return i;
		return -1;
	}

	static int getEnd(int u2v[], int i) {
		while (u2v[i] != 0)
			i = u2v[i];
		return i;
	}
		
}
