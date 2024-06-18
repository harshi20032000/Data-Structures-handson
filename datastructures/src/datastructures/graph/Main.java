package datastructures.graph;

public class Main {

	public static void main(String[] args) {
//		 Graph myGraph = new Graph();
//	        
//	        myGraph.addVertex("A");
//	        myGraph.addVertex("B");
//	        
//	        System.out.println("\nGraph:");
//	        myGraph.printGraph();
//
//	        /*
//	            EXPECTED OUTPUT:
//	            ----------------
//	            Graph:
//	            {A=[], B=[]}
//
//	        */
		
//		 Graph myGraph = new Graph();
//
//	        myGraph.addVertex("A");
//	        myGraph.addVertex("B");
//
//
//	        System.out.println("\nGraph before addEdge():");
//	        myGraph.printGraph();
//
//
//	        myGraph.addEdge("A", "B");
//
//
//	        System.out.println("\nGraph after addEdge():");
//	        myGraph.printGraph();
//
//
//	        /*
//	            EXPECTED OUTPUT:
//	            ----------------
//	            Graph before addEdge():
//	            {A=[], B=[]}
//	            
//	            Graph after addEdge():
//	            {A=[B], B=[A]}
//
//	        */
		
//		 Graph myGraph = new Graph();
//
//	        myGraph.addVertex("A");
//	        myGraph.addVertex("B");
//	        myGraph.addVertex("C");
//
//	        myGraph.addEdge("A", "B");
//	        myGraph.addEdge("A", "C");
//	        myGraph.addEdge("B", "C");
//
//
//	        System.out.println("\nGraph before removeEdge():");
//	        myGraph.printGraph();
//
//	        myGraph.removeEdge("A", "B");
//
//	        System.out.println("\nGraph after removeEdge():");
//	        myGraph.printGraph();
//
//	        /*
//	            EXPECTED OUTPUT:
//	            ----------------
//	            Graph before removeEdge():
//	            {A=[B, C], B=[A, C], C=[A, B]}
//	            
//	            Graph after removeEdge():
//	            {A=[C], B=[C], C=[A, B]}
//
//	        */
		
		Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "D");
        myGraph.addEdge("C", "D");


        System.out.println("\nGraph before removeVertex():");
        myGraph.printGraph();

        myGraph.removeVertex("D");

        System.out.println("\nGraph after removeVertex():");
        myGraph.printGraph();
        
        /*
            EXPECTED OUTPUT:
            ----------------
            Graph before removeVertex():
            {A=[B, C, D], B=[A, D], C=[A, D], D=[A, B, C]}
            
            Graph after removeVertex():
            {A=[B, C], B=[A], C=[A]}

        */

	}

}
