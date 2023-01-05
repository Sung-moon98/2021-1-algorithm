package Algo21_2;

public class WgraphTest1 {

	public static void main(String[] args) {
		Wgraph gr = new Wgraph(6);

        gr.insertEdge(0, 1, 5);
        gr.insertEdge(0, 2, 4);
        gr.insertEdge(1, 2, 2);
        gr.insertEdge(1, 3, 7);
        gr.insertEdge(2, 3, 6);
        gr.insertEdge(2, 4, 11);
        gr.insertEdge(3, 4, 3);
        gr.insertEdge(3, 5, 8);
        gr.insertEdge(4, 5, 8);
        

        System.out.println("Kruskal");

        Edge[] edgelist = gr.spanningTree();
        for (int i = 0; i < edgelist.length; i++)
            System.out.print("(" + edgelist[i].tail + " " + edgelist[i].head + ") ");


        System.out.println();
        System.out.println("Prim");

        edgelist = gr.prim(0);
        for (int i = 0; i < edgelist.length; i++)
            System.out.print("(" + edgelist[i].tail + " " + edgelist[i].head + ") ");


        System.out.println();
	}

}
