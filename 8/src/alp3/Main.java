package alp3;

public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		System.out.println("start bfs");
		new SolutionSearcher().breadthFirstSearch(graph.getNodes().get(0));
	}

}
