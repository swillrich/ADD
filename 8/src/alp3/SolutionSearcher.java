package alp3;

import java.util.EnumSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SolutionSearcher {

	public void breadthFirstSearch(Node startNode) {
		Set<Node> visited = new TreeSet<Node>();
		PriorityQueue<Node> pQ = new PriorityQueue<Node>();
		pQ.add(startNode);
		while (!pQ.isEmpty()) {
			Node node = pQ.poll();
			visited.add(node);
			boolean isSolution = checkIfStateOfNodeIsSolution(node);
			if (isSolution) {
				showSolutionWay(node);
				break;
			}
			for (Node next : node.getOutgoing()) {
				if (!visited.contains(next)) {
					next.setPredecessor(node);
					pQ.add(next);
				}
			}
		}
	}

	private void showSolutionWay(Node node) {
		System.out.println("Solution found");
		Stack<Node> stack = new Stack<Node>();
		Node pre = node;
		while (pre != null) {
			stack.add(pre);
			pre = pre.getPredecessor();
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().toString());
		}
	}

	private boolean checkIfStateOfNodeIsSolution(Node node) {
		boolean isBootEmpty = node.getBoot().size() == 0;
		boolean isUfer1Empty = node.getUfer1().size() == 0;
		if (!isBootEmpty || !isUfer1Empty) {
			return false;
		}
		EnumSet<E> u2 = node.getUfer2();
		boolean containsM = u2.contains(E.M);
		boolean containsW = u2.contains(E.W);
		boolean containsZ = u2.contains(E.Z);
		boolean containsK = u2.contains(E.K);
		return containsM && containsW && containsZ && containsK;
	}
}
