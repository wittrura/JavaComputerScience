package main;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;


//This represents a non-directional Graph
//Values of nodes can contain strings
public class Graph {

  ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
  ArrayList<GraphEdge> edges = new ArrayList<GraphEdge>();

  public Graph () {}

  // Helper function to find a node in nodes
  public GraphNode findNode (String value) {
    for (GraphNode node : nodes) {
      if (node.value.equals(value)) {
        return node;
      }
    }
    return null;
  }

  // Add a node to the list of nodes
  public void addNode (String value) {
    GraphNode node = new GraphNode(value);
    if (findNode(value) != null) {
      return;
    }
    nodes.add(new GraphNode(value));
  }

  // Add an edge between 2 nodes and give it a weight
  public void addEdge (String source, String dest, int weight) {
    GraphNode first = findNode(source);
    GraphNode second = findNode(dest);
    if (first == null || second == null) {
      return;
    }
    edges.add(new GraphEdge(first, second, weight));
  }

  // Get the size of the graph by returning how many nodes are in the graph
  public int size () {
    return this.nodes.size();
  }

  // Find the total number of edges in the graph
  public int numEdges () {
      return this.edges.size();
  }

  // Find the total weight of the graph by adding up the weights of each edge
  public int weight () {
      int numEdges = this.numEdges();
      int weight = 0;
      for (int i = 0; i < numEdges; i++) {
          weight += this.edges.get(i).weight;
      }
      return weight;
  }

  // Find all node values a node is connected to.
  // Return all node values at the other side of an edge of the target node
  // Remember that edges are not directional: A -> B also implies B -> A
  public ArrayList<String> findNeighbors(String value) {
      ArrayList<String> neighbors = new ArrayList<String>();
      this.edges.forEach((edge) -> {
          if (edge.first.value.equals(value)) {
              neighbors.add(edge.second.value);
          } else if (edge.second.value.equals(value)) {
              neighbors.add(edge.first.value);
          }
      });

    return neighbors;
  }


  // Stretch!
  // Find the optimal route from start to finish
  // Return each edge required to traverse the route
  // Remember that edges are not directional: A -> B also implies B -> A
  public ArrayList<GraphEdge> findPath (String start, String finish) {
      // Dijkstra's
      ArrayList<GraphEdge> path = new ArrayList();

      Comparator<Vertex> comparator = new VertexDistanceComparator();
      PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(this.nodes.size(), comparator);

      // build min priority queue with starting point at zero, all others equal to infinity
      for (int i = 0; i < nodes.size(); i++) {
          Vertex newVertex = new Vertex(nodes.get(i));
          if (newVertex.value.equals(start)) newVertex.distance = 0;
          queue.add(newVertex);
      }

      while (queue.size() > 0) {
          // remove 'nearest' node from queue, lowest distance
          Vertex vertex = queue.poll();
          if (vertex.value.equals(finish)) {
              return path;
          }

          // get edges to all neighbors
          ArrayList<GraphEdge> vertexEdges = new ArrayList();
          for (int i = 0; i < this.edges.size(); i++) {
              if (this.edges.get(i).first.value.equals(vertex.value) || this.edges.get(i).second.value.equals(vertex.value)) {
                  vertexEdges.add(this.edges.get(i));
              }
          }

          // update min priority queue based on edges
          for (int j = 0; j < vertexEdges.size(); j++) {
              if (vertexEdges.get(j).first.value.equals(vertex.value)) {
                  // if first node is start, then use the second node and find the corresponding vertex to update min priority queue
                  this.updateDistance(vertexEdges.get(j), vertexEdges.get(j).second, queue, vertex);
              } else {
                  // else, use the first node and find the corresponding vertex to update min priority queue
                  this.updateDistance(vertexEdges.get(j), vertexEdges.get(j).first, queue, vertex);
              }
          }
      }


      // System.out.println(queue.peek().distance);
      return path;
  }

  public void updateDistance (GraphEdge edge, GraphNode node, PriorityQueue<Vertex> queue, Vertex startingVertex) {
      Iterator it = queue.iterator();
      while (it.hasNext()) {
          Vertex vertex = (Vertex)it.next();
          if (vertex.value.equals(node.value)) {
              vertex.distance = edge.weight + startingVertex.distance;
              break;
          }
      }
  }


  // Return a list of any nodes that are orphans.
  // An orphan is any node with no edges.
  public ArrayList<GraphNode> findOrphans () {
      ArrayList<GraphNode> orphans = new ArrayList<GraphNode>();

      Hashtable<String, Integer> nodeFrequency = new Hashtable<String, Integer>();

      int numNodes = this.nodes.size();
      for (int i = 0; i < numNodes; i++) {
          nodeFrequency.put(this.nodes.get(i).value, 0);
      }

      int numEdges = this.edges.size();
      for (int i = 0; i < numEdges; i++) {
          nodeFrequency.put(this.edges.get(i).first.value, nodeFrequency.get(this.edges.get(i).first.value) + 1);
          nodeFrequency.put(this.edges.get(i).second.value, nodeFrequency.get(this.edges.get(i).second.value) + 1);
      }

      Set<String> keys = nodeFrequency.keySet();
      for (String key: keys){
          if (nodeFrequency.get(key) == 0) {
              for (int i = 0; i < numNodes; i++) {
                  if (this.nodes.get(i).value.equals(key)){
                   orphans.add(this.nodes.get(i));
                  }
              }
          }
      }

      return orphans;
  }

  public void print () {
    for (GraphEdge edge : edges) {
      System.out.printf("%18s -> %-18s %6d mi\n",
        edge.first.value, edge.second.value, edge.weight);
    }
  }

  public static int pathWeight (ArrayList<GraphEdge> path) {
    int sum = 0;
    for (GraphEdge edge : path) {
      sum += edge.weight;
    }
    return sum;
  }

  public static class GraphNode {

    String value;

    public GraphNode (String value) {
      this.value = value;
    }

  }

  public class GraphEdge  {

    GraphNode first;
    GraphNode second;
    int weight;

    public GraphEdge (GraphNode first, GraphNode second, int weight) {
      this.first = first;
      this.second = second;
      this.weight = weight;
    }

  }

  public class Vertex {
      String value;
      double distance;

      Vertex(GraphNode node) {
          this.value = node.value;
          distance = Double.POSITIVE_INFINITY;
      }
  }

  public class VertexDistanceComparator implements Comparator<Vertex> {
    public int compare(Vertex x, Vertex y) {
        if (x.distance < y.distance) {
            return -1;
        }

        if (x.distance > y.distance) {
            return 1;
        }
        return 0;
    }
  }

}
