package engine.datastructure;

import engine.model.RoutingResult;
import java.util.*;

public class DijkstraEngine {

    // Helper data structure to handle Priority Queue extraction comparisons
    private static class PathNode implements Comparable<PathNode> {
        String id;
        double currentShortestDistance;

        PathNode(String id, double currentShortestDistance) {
            this.id = id;
            this.currentShortestDistance = currentShortestDistance;
        }

        @Override
        public int compareTo(PathNode o) {
            return Double.compare(this.currentShortestDistance, o.currentShortestDistance);
        }
    }

    /**
     * Executes Dijkstra's algorithm from a target hospital node.
     * Evaluates and sorts the shortest paths to locate the TOP 3 nearest donor nodes.
     */
    public static List<RoutingResult> findTopThreeDonors(RouteGraph graph, String hospitalNodeId) {
        GraphNode startNode = graph.getNode(hospitalNodeId);
        if (startNode == null) {
            throw new IllegalArgumentException("Target hospital node does not exist inside the routing matrix.");
        }

        Map<String, Double> distances = new HashMap<>();
        Map<String, String> parentNodes = new HashMap<>();
        PriorityQueue<PathNode> pq = new PriorityQueue<>();

        // Initialize spatial grid bounds
        for (String nodeKey : graph.getAllNodes().keySet()) {
            distances.put(nodeKey, Double.MAX_VALUE);
        }

        distances.put(hospitalNodeId, 0.0);
        pq.add(new PathNode(hospitalNodeId, 0.0));

        while (!pq.isEmpty()) {
            PathNode current = pq.poll();
            String currentId = current.id;
            double currentDist = current.currentShortestDistance;

            // Skip processing if a shorter path has already been locked in
            if (currentDist > distances.get(currentId)) continue;

            GraphNode nodeObj = graph.getNode(currentId);
            if (nodeObj == null) continue;

            for (GraphEdge edge : nodeObj.getEdges()) {
                GraphNode neighbor = edge.getDestination();
                double newDist = currentDist + edge.getWeight();

                if (newDist < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), newDist);
                    parentNodes.put(neighbor.getId(), currentId);
                    pq.add(new PathNode(neighbor.getId(), newDist));
                }
            }
        }

        // Collect all processed donor nodes that were reached by the system
        List<RoutingResult> donorMatches = new ArrayList<>();
        for (GraphNode node : graph.getAllNodes().values()) {
            if (node.getType() == GraphNode.NodeType.DONOR && distances.get(node.getId()) < Double.MAX_VALUE) {
                List<String> constructedPath = reconstructPath(parentNodes, node.getId(), hospitalNodeId);
                donorMatches.add(new RoutingResult(node, distances.get(node.getId()), constructedPath));
            }
        }

        // Sort the candidates by total distance (ascending)
        donorMatches.sort(Comparator.comparingDouble(RoutingResult::getTotalDistance));

        // Slice and return only the top 3 closest entries
        if (donorMatches.size() > 3) {
            return donorMatches.subList(0, 3);
        }
        return donorMatches;
    }

    private static List<String> reconstructPath(Map<String, String> parents, String targetId, String startId) {
        LinkedList<String> path = new LinkedList<>();
        String step = targetId;

        if (parents.get(step) == null && !step.equals(startId)) {
            return path; // Target unreachable
        }

        while (step != null) {
            path.addFirst(step);
            step = parents.get(step);
        }
        return path;
    }
}