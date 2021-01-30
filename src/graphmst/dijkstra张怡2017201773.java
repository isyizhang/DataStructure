package graphmst;


public class dijkstra张怡2017201773  {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) {
		char c[] = new char[] {'A','B','C','D','E'};
		int[][] map = new int[][] {
			{0,2,6,MAX,1},
			{2,0,5,4,MAX},
			{6,5,0,10,1},
			{MAX,4,10,0,2},
			{1,MAX,1,2,0}
		};
		int[] dis = new int[5];//保存路径
		boolean[] visited = new boolean[5];//保存节点路径是否已被确定
		visited[0] = true;//把第一个节点放入，设为已确定
		for(int i=0;i < map.length;i++) {//将初始路径导入
			dis[i] = map[0][i];
		}
		dijkstra(map,dis,visited);
		for(int i=0;i<dis.length;i++)
            System.out.println("到"+c[i]+"的距离是"+dis[i]+" ");
	}
	
	public static void dijkstra(int[][]graph, int[]dis, boolean[] visited) {
		while(true){
            int min=Integer.MAX_VALUE;
            int index=-1;
            for(int i=0;i<dis.length;i++){//每次找到最短路径
                if(visited[i])
                    continue;//节点已确定则跳过
                else{
                    if(dis[i]<min){
                        index=i;
                        min=dis[i];
                    }
                }
            }
            if(index==-1) break;//所有节点都已确定
            visited[index]=true;
            for(int i=0;i<graph.length;i++){//更新其他节点路径距离
                if(graph[index][i]!=Integer.MAX_VALUE){
                    dis[i]=dis[i]<(min+graph[index][i])?dis[i]:min+graph[index][i];
                }
            }
        }
	}
		

}
