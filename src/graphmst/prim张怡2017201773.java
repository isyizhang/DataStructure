package graphmst;

import java.util.ArrayList;

public class prim张怡2017201773 {
	static int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[][] map = new int[][] { //用的例子是一个无向图
			{0,2,6,MAX,1},
			{2,0,5,4,MAX},
			{6,5,0,10,1},
			{MAX,4,10,0,2},
			{1,MAX,1,2,0}
		};
		prim(map, map.length);
	}
	
	public static void prim(int[][]graph, int n) {
		char[] c = new char[] {'A','B','C','D','E'};
		int[] weight = new int[n];//保存边的权值
		int[] f = new int[n];//保存节点的上一节点
		ArrayList<Character> list = new ArrayList<Character>();
		int min, minid=0;
		for(int i=1;i<n;i++) {//初始化两个数组
			weight[i] = graph[0][i];
			f[i] = 0;
		}
		list.add(c[0]);//把第一个节点加入
		for(int i=1;i < n;i++) {
			min=MAX;
			minid=0;
			for(int j=1;j<n;j++) {
				if(weight[j]!=0&&weight[j]<min) {//找到最小权值边
					min=weight[j];
					minid=j;
				}
			}
			if(minid==0) return;
			list.add(c[minid]);//加入该节点
			weight[minid] = 0;//将该边权值设为0，不再被选中
			System.out.println(c[f[minid]] + "---" + c[minid] + "权值：" + min);
			for(int j = 1;j<n;j++) {
				if(weight[j]!=0&&weight[j]>graph[minid][j]) {
					weight[j] = graph[minid][j];
					f[j] = minid;
				}
			}
		}
		
	}

}
