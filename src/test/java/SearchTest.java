package main;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SearchTest {

    public ArrayList<String> readFile (String filename) {
        ArrayList<String> lines = new ArrayList<String>();
        String line = null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return lines;
    }

    public Graph readGraph (String filename) {
        Graph graph = new Graph();
        ArrayList<String> lines = readFile(filename);
        for (String line : lines) {
            String[] fields = line.split(",");
            graph.addNode(fields[0]);
            graph.addNode(fields[1]);
            graph.addEdge(fields[0], fields[1], Integer.parseInt(fields[2]));
        }
        return graph;
    }

   @Test
   public void bfs() {
     Graph cityGraph = readGraph("./src/test/fixture/cityGraph.txt");
     Assert.assertEquals(true, Search.bfs("Denver", cityGraph));
     Assert.assertEquals(false, Search.bfs("New York", cityGraph));
   }

   @Test
   public void dfs() {
     Graph cityGraph = readGraph("./src/test/fixture/cityGraph.txt");
     Assert.assertEquals(true, Search.dfs("Denver", cityGraph));
     Assert.assertEquals(false, Search.dfs("New York", cityGraph));
   }

}
