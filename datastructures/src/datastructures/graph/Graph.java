package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

	public boolean addVertex(String vertex) {
		if(!adjList.containsKey(vertex)) {
			adjList.put(vertex, new ArrayList<>());
			return true;
		}
		return false;
	}

	public boolean addEdge(String string, String string2) {
		if(adjList.containsKey(string) && adjList.containsKey(string2)) {
			adjList.get(string2).add(string);
			adjList.get(string).add(string2);
			return true;
		}
		System.out.println("any one of vertex is not present!");
		return false;
	}

	public boolean removeEdge(String string, String string2) {
		if(adjList.containsKey(string) && adjList.containsKey(string2)) {
			adjList.get(string2).remove(string);
			adjList.get(string).remove(string2);
			return true;
		}
		System.out.println("any one of vertex is not present!");
		return false;
		
	}

	public boolean removeVertex(String vertex) {
		if(adjList.containsKey(vertex)) {
			adjList.get(vertex).forEach(eachVertex->{
				adjList.get(eachVertex).remove(vertex);
			});
			adjList.remove(vertex);
			return true;
		}
		return false;
	}
}
