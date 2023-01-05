package Algo21_2;

public class WDgraph {
	int n; //Number of vertices
    int e; // Number of edges
    int [][] weight;
    
    public WDgraph(int noOfVertices) {
        n = noOfVertices;
        e = 0;
        weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) weight[i][j] = 0;
                else weight[i][j] = 9999; 
            }
        }
    }
    
    public WDgraph() {
        n = 0;
        e = 0;
    }
    
    public void insertEdge(int i, int j, int w) {
    	weight[i][j] = w;
    	e++;
    }
    
    public void removeEdge(int i, int j) {
    	weight[i][j] = 9999;
    	e--;
    }
    
    public int[] shortestPath(int v) {
    	boolean visited[] = new boolean[n];
    	int[] D = new int[n];
    	
    	for(int i = 0; i < n; i++) {
    		visited[i] = false;
    		D[i] = 9999;
    	}
    	
    	visited[v] = true;
    	D[v] = 0;
    	
    	for(int i = 0; i < n; i++) {
    		D[i] = weight[v][i];
    	}
    	
    	for(int k = 0; k < n-1; k++) {
    		int minVertex = -1;				// D원소 값이 최소인 minVertex 찾기
    		int min = 9999;
			for(int j = 0; j < n; j++) {
				if((!visited[j]) && (D[j] < min)) {		
					min = D[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;			// 최소정점 방문
			
			for(int j = 0; j < n; j++) {
				if(weight[minVertex][j] > 0 && weight[minVertex][j] < 9999) {	// minVertex와 인접해있다면
					if(!visited[j]) {				// 방문되어있지 않다면
						int current = D[j];
						int newWeight = D[minVertex] + weight[minVertex][j];
						
						if(current > newWeight) {
							D[j] = newWeight;
						}
					}
				}
			}
  
    	}
    	
    	return D;
    }
    
    public int[] negativePath(int v) {		// 음의 정수 포함
    	int[] D = new int[n];
    	
    	for(int i = 0; i < n; i++)
			D[i] = 9999;		// 초기화
    	
		D[v] = 0; 
		
		for(int k = 0; k < n-1; k++) {			// n-1번 반복, 시작점에서 도착점까지 이용할 수 있는 최대 간선 수
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(weight[i][j] != 9999 && weight[i][j] != 0) {				// 인접해있다면
						if(D[j] > D[i] + weight[i][j]) {
							D[j] = D[i] + weight[i][j];		// 간선완화
						}
					}
				}
			}
		}
		
		return D;
    }

    public int[][] allShortestPath() {		// 모든 정점 쌍 간 최단 경로
    	int[][] D = new int[n][n];
    	D = weight;
    	
    	for(int k = 0; k < n; k++) {			// n번 반복
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}	
				}
			}
    	}	
    	return D;
    }
}
