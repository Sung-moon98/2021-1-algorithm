package Algo21_2;

public class Wgraph {	// Matrix
	int n; //Number of vertices
    int e; // Number of edges
    int [][] weight;
    
    public Wgraph(int noOfVertices) {
        n = noOfVertices;
        e = 0;
        weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (i == j) weight[i][j] = 0;
                else weight[i][j] = 9999; // 9999?
            }
        }
    }
    
    public Wgraph() {
        n = 0;
        e = 0;
    }
    
    public void insertEdge(int i, int j, int w) {
    	weight[i][j] = w;
    	weight[j][i] = w;
    	e++;
    }
    
    public void removeEdge(int i, int j) {
    	weight[i][j] = 9999;
    	weight[j][i] = 9999;
    	e--;
    }
    
    public Edge[] spanningTree() { 		// Kruskal
    	UnionFind uf = new UnionFind(n);
    	Edge[] t = new Edge[n-1];
    	int min;					// 최소가중치
    	int k = 0;
  
     	MinHeap h = new MinHeap();		// edgelist
     	for(int i = 0; i < n; i++){
     		for(int j = i+1; j < n; j++) {
     			if(weight[i][j] != 9999)
     				h.insert(weight[i][j]);
     		}
     	}
     	
     	while(!h.isEmpty() && k < n-1) {
     		min = h.delete();
     		for(int i = 0; i < n; i++){
         		for(int j = n-1; j > 0; j--) {
         			if(weight[i][j] == min) {
         				if(!uf.find(i, j)) {
         					uf.union(i, j);
         					t[k] = new Edge(j, i, min);
         					k++;
         				}
         			}
         		}
     		}
     	}
     	return t;
    }

    public Edge[] prim(int s) { 		// Prim
    	Edge[] t = new Edge[n-1];
    	UnionFind uf = new UnionFind(n);
    	int D[] = new int[n];					// 정점에 도착하는 최소 가중치
    	int previous[] = new int[n];			// 이전 정점
    	
    	for(int i = 0; i < n; i++) {
    		D[i] = weight[s][i];
    		previous[i] = s;
    	}
    	
    	int k = 0;
    	int minVertex = 0;
    	
    	
    	while(k < n-1){
    		int best = isBest(D);
    		
    		
    		
    		if(!uf.find(previous[best], best)) {
    			t[k] = new Edge(best, previous[best], D[best]);
        		k++;
        		D[best] = 0;
        		uf.union(previous[best], best);
    		}
    		
    		
    		for(int j = 0; j < n; j++) {
    			if(weight[best][j] < D[j] && !uf.find(best, j)) {
    				previous[j] = best;
    				D[j] = weight[best][j];
    			}
    		}
    	}
    	return t;		
    }
    
    
    public static int isBest(int[] D) { 		// D 배열 중 0을 제외한 최소값을 가진 원소의 인덱스를 반환하는 메소드
    	int best = 0;
		
		for(int i = 0; i < D.length; i++) {
				if(D[i] != 9999 && D[i] > 0) {
					best = i;
					break;
				}
		}
		for(int j = 0; j < D.length; j++) { 			// D에서 0이아닌 값 중 값이 가장 작은 인덱스를 찾는다.
			if(D[j] != 0 && D[j] < D[best]) {
				best = j;
			}
		}
				
		return best;
    }
    		
    		

    		
    	
    
}
