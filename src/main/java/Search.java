package main;

import java.util.*;

public class Search {
  // Search functions will simply traverse a graph
  // and return true if the value is found.
  // Use a random starting node.
  // The findNeighbors() method will be useful,
  // make sure to complete the Graph exercise first.

  public static boolean dfs (String value, main.Graph graph) {
//      choose random node
      main.Graph.GraphNode startingNode = graph.nodes.get(0);
//      navigate down to child, then that child's child, until there are no more children
//      then go back up and over to siblings
    return false;
  }

  public static boolean bfs (String value, main.Graph graph) {
      main.Graph.GraphNode startingNode = graph.nodes.get(0);

      if (startingNode.value.equals(value)) {
          return true;
      }

      // navigate left to right, visiting all children
      ArrayList<String> neighbors = graph.findNeighbors(startingNode.value);
      for (int i = 0; i < neighbors.size(); i++) {
          if (neighbors.get(i).equals(value)) {
              return true;
          }
      }

//      while (neighbors.size() > 0) {
//
//      }

      // repeat for left most child

      return false;
  }
}
