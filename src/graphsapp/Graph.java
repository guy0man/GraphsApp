
package graphsapp;

import java.util.*;


public class Graph {
    
    private int V;
    
    private LinkedList<Integer>[] adj;
    
    ArrayList<ArrayList<Integer>> components = new ArrayList<>();
    
    public Graph(int v){
        
        V = v;
        adj = new LinkedList[v];
        
        for (int i = 0;i < v; i++){
            adj[i] = new LinkedList();
        }
        
    }
    void addEdge (int u, int w){
        adj[u].add(w);
        adj[w].add(u);
    }
    
    void DFSUtil(int v, boolean[] visited, ArrayList<Integer> al){
        
        visited[v] = true;
        al.add(v);
        Iterator<Integer> it = adj[v].iterator();
        
        while(it.hasNext()){
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited, al);
        }       
    }
    void DFS(){
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++){
            ArrayList<Integer> al = new ArrayList<>();
            if (!visited[i]){
                DFSUtil(i,visited,al);
                components.add(al);
            }        
        }         
    }
    int ConnectedComponents() {
        return components.size();
    }
    
}
