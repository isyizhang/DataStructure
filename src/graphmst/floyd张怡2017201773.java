package graphmst;


public class floyd张怡2017201773 {
	static int MAX = Integer.MAX_VALUE;
	static int[][] map = new int[][] {
		{0,2,6,MAX,1},
		{2,0,5,4,MAX},
		{6,5,0,10,1},
		{MAX,4,10,0,2},
		{1,MAX,1,2,0}
	};
	static char[]c = new char[] {'A','B','C','D','E'};
	static int[][]dist = new int[5][5];
	static int[][]path = new int[5][5];
	
	public static void main(String[] args) {
		floyd(dist, path);
		
	}
	
	public static void floyd(int[][]dist, int[][]path) {
		for(int i=0;i<c.length;i++) {//初始化
			for(int j=0;j<c.length;j++) {
				dist[i][j] = map[i][j];
				path[i][j] = j;//最短路径是经过'j'
			}
		}
		
		for(int k=0;k<c.length;k++) {
			for(int i=0;i<c.length;i++) {
				for(int j=0;j<c.length;j++) {
					//若经过k顶点路径比原来路径更短，则更新dist[i][j]和path[i][j]
					int temp = (dist[i][k]==MAX||dist[k][j]==MAX)?MAX:(dist[i][k]+dist[k][j]);
					if(temp < dist[i][j]) {
						dist[i][j] = temp;
						path[i][j] = path[i][k];
					}
				}
			}
		}
		//打印最短路径的矩阵
		System.out.printf("floyd: \n");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++)
                System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }
		
	}

}
