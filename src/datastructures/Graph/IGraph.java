package datastructures.Graph;

import java.util.ArrayList;

import datastructures.NaryTree.NaryTree;



public interface IGraph<V> {
    public Vertex<V> insertVertex(Vertex<V> vertex);
    public boolean insertEdge(Vertex<V> v1, Vertex<V> v2);
    public boolean deleteVertex(Vertex<V> vertex);
    public boolean deleteEdge(Vertex<V> v1, Vertex<V> v2);
    public NaryTree<V> BFS(Vertex<V> s);
    public ArrayList<NaryTree<V>> DFS();
    public void DFSV(Vertex<V> u, NaryTree<V> n);
}
