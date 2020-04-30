import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class GraphImplementation implements Graph
{
	public int[][] graph;
	public int size;
	public List<Integer> sortedList;

	public GraphImplementation(int vertices) {
		size = vertices;
		graph = new int[size][size];
		sortedList = new ArrayList<>();
	}

	public void addEdge(int v1, int v2) throws Exception {
		if (v1>=size || v2>=size) {
			throw new Exception();
		}
		graph[v1][v2] = 1;
	}

	public List<Integer> topologicalSort() {
		int[] n = new int[size];
		for (int j=0; j<size; j++) {
			for (int i=0; i<size; i++) {
				if (graph[i][j] == 1) {
					n[j]++;
				}
			}
		}

		while (sortedList.size() != size) {
			for (int i=0; i<n.length; i++) {
				if (n[i] == 0) {
					sortedList.add(i);
					n[i] = -1;
					for (int j=0; j<size; j++) {
						if (graph[i][j] != 0) {
							n[j]--;
						}
					}
				}
			}
		}

		return sortedList;

	}

	public List<Integer> neighbors(int vertex) throws Exception {
		if (vertex >= size) {
			throw new Exception();
		}
		List<Integer> neighbors = new ArrayList<>();
		for (int i=0; i<graph.length; i++) {
			if (graph[vertex][i] == 1) {
				neighbors.add(i);
			}
		}
		return neighbors;
	}
}