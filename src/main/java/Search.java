package main;

import java.util.*;
import java.util.Stack;


public class Search {
  // Search functions will simply traverse a graph
  // and return true if the value is found.
  // Use a random starting node.
  // The findNeighbors() method will be useful,
  // make sure to complete the Graph exercise first.

  public static boolean dfs (String value, main.Graph graph) {
      Stack<String> stack = new Stack();
      ArrayList<String> checkedNodes = new ArrayList();

      // start at any node
      main.Graph.GraphNode node = graph.nodes.get(0);
      stack.push(node.value);


      // loop while the stack is not empty
      while (stack.size() > 0) {

          // check if node is equal to searched value, if it is return true
          if (node.value.equals(value)) {
              return true;
          } else {
              // if it is not, add it to thehecked list;
              checkedNodes.add(node.value);
          }

          // if node has unseen children, chose one and set that to node
          ArrayList<String> neighbors = graph.findNeighbors(node.value);

          boolean hasUnseenNeighbors = false;
          for (int i = 0; i < neighbors.size(); i++) {
              if (!checkedNodes.contains(neighbors.get(i))) {
                  node = graph.findNode(neighbors.get(i));
                  hasUnseenNeighbors = true;
                  break;
              }
          }

          if (hasUnseenNeighbors) {
              // add the newly selected node to the stack
              stack.add(node.value);
          } else {
              // pop off node from the stack and move back a level, so set node = next item on the stack
              stack.pop();
              if (stack.size() != 0) node = graph.findNode(stack.peek());
          }

      }

      return false;
  }

  public static boolean bfs (String value, main.Graph graph) {
      ArrayList<String> checkedNodes = new ArrayList();
      ArrayList<String> nodesToCheck = new ArrayList(); // TODO - implement as queue

      main.Graph.GraphNode node = graph.nodes.get(0);
      nodesToCheck.add(node.value);

      // loop if queue is NOT empty
      while (nodesToCheck.size() > 0) {
          // remove first node from queue and set to base
          node = graph.findNode(nodesToCheck.remove(0));

          // check base node for value
          if (node.value.equals(value)) return true;

          // add base node to 'checked' list
          checkedNodes.add(node.value);

          // get all neighboring nodes
          ArrayList<String> neighbors = graph.findNeighbors(node.value);

          // add neighboring nodes to unseen queue IF not in 'checked' list
          for (int i = 0; i < neighbors.size(); i++) {
              if (!checkedNodes.contains(neighbors.get(i))) {
                  nodesToCheck.add(neighbors.get(i));
              }
          }
      }
      return false;
  }

  private static boolean bfs (String value, main.Graph.GraphNode node) {
      return true;
  }

}
