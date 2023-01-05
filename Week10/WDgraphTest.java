package Algo21_2;

public class WDgraphTest {
	public static void main(String[] args) {
		  WDgraph gr = new WDgraph(5);

	        gr.insertEdge(0, 1, 2);
	        gr.insertEdge(0, 2, 5);
	        gr.insertEdge(0, 4, 3);
	        gr.insertEdge(1, 3, 4);
	        gr.insertEdge(1, 4, 10);
	        gr.insertEdge(2, 3, 6);
	        gr.insertEdge(2, 4, 2);
	        gr.insertEdge(4, 2, 1);
	        gr.insertEdge(4, 3, 2);

	        int[] sp = gr.shortestPath(0);
	        
	        System.out.println("Dijkstra");
	        for (int i = 0; i < sp.length; i++) {
	            System.out.println("0 -> " + i + ": " + sp[i]);
	        }
	        
	        System.out.println();
	        
	        gr = new WDgraph(6);

	        gr.insertEdge(0, 1, 6);
	        gr.insertEdge(0, 2, 5);
	        gr.insertEdge(0, 3, 5);
	        gr.insertEdge(1, 4, -1);
	        gr.insertEdge(2, 1, -2);
	        gr.insertEdge(2, 4, 1);
	        gr.insertEdge(3, 2, -3);
	        gr.insertEdge(3, 5, -1);
	        gr.insertEdge(4, 5, 3);

	        sp = gr.negativePath(0);
	        System.out.println("Bellman and Ford");
	        for (int i = 0; i < sp.length; i++) {
	            System.out.println("0 -> " + i + ": " + sp[i]);
	        }
	        

	        gr = new WDgraph(6);

	        gr.insertEdge(0, 1, 5);
	        gr.insertEdge(0, 2, 4);
	        gr.insertEdge(1, 2, 2);
	        gr.insertEdge(1, 3, 7);
	        gr.insertEdge(2, 3, 6);
	        gr.insertEdge(2, 4, 11);
	        gr.insertEdge(3, 4, 3);
	        gr.insertEdge(3, 5, 8);
	        gr.insertEdge(4, 5, 8);

	        System.out.println();

	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 6; j++) {
	                System.out.print(gr.weight[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();


	        int shPath[][] = gr.allShortestPath();
	        for (int i = 0; i < 6; i++) {
	            for (int j = 0; j < 6; j++) {
	                System.out.print(shPath[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();


	        gr = new WDgraph(4);

	        gr.insertEdge(0, 1, 2);
	        gr.insertEdge(0, 2, 9);
	        gr.insertEdge(1, 0, 5);
	        gr.insertEdge(1, 2, 4);
	        gr.insertEdge(1, 3, 3);
	        gr.insertEdge(2, 0, -1);
	        gr.insertEdge(2, 3, 4);
	        gr.insertEdge(3, 1, 1);
	        gr.insertEdge(3, 2, 7);

	        System.out.println();

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print(gr.weight[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();


	        shPath = gr.allShortestPath();

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                System.out.print(shPath[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();
	       
		
	}

}
