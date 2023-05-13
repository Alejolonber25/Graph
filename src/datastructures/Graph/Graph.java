package datastructures.Graph;

import datastructures.NaryTree.NaryTree;
import datastructures.NaryTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Objects;
public class Graph<V> implements IGraph<V>{
    boolean addressed;
    ArrayList<Vertex<V>> vertexList;
    
    int time;
    public Graph(boolean addressed) {
        this.addressed = addressed;
        vertexList = new ArrayList<>();
    }

    @Override
    public Vertex<V> insertVertex(Vertex<V> vertex) {
        if(!vertexList.contains(vertex)){
            vertexList.add(vertex);
            return vertex;
        }
        return null;
    }

    @Override
    public boolean insertEdge(Vertex<V> v1, Vertex<V> v2) {
        if(addressed){
            if(!v1.getAdjacencyList().contains(v2)){
                v2.getAdjacencyList().add(v1);
                return true;
            }
        }else{
            if(!v1.getAdjacencyList().contains(v2) && !v2.getAdjacencyList().contains(v1) ){
                v1.getAdjacencyList().add(v2);
                v2.getAdjacencyList().add(v1);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteVertex(Vertex<V> vertex) {
        if (vertexList.contains(vertex)){
            for (Vertex<V> v: vertexList) {
                if (v != vertex){
                    v.getAdjacencyList().remove(vertex);
                }
            }
            vertexList.remove(vertex);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteEdge(Vertex<V> v1, Vertex<V> v2) {
        if(addressed){
            v1.getAdjacencyList().remove(v2);
            return true;
        }else{
            v1.getAdjacencyList().remove(v2);
            v2.getAdjacencyList().remove(v1);
        }
        return false;
    }

    @Override
    public NaryTree<V> BFS(Vertex<V> s) {
        NaryTree<V> naryTree = new NaryTree<>();
        naryTree.setRoot(new Node<>(s.value));
        Queue<Vertex<V>> queue = new LinkedList<>();

        for (Vertex<V> u :vertexList) {
            u.setColor(Color.WHITE);
            u.setDistance(Integer.MAX_VALUE);
            u.setPredecessor(null);
        }
        s.setColor(Color.GRAY);
        s.setDistance(0);
        s.setPredecessor(null);
        queue.add(s);
        while(!queue.isEmpty()){
            Vertex<V> u = queue.poll();
            for (Vertex<V> v : u.getAdjacencyList()){
                if(v.getColor() == Color.WHITE){
                    v.setColor(Color.GRAY);
                    v.setDistance(u.getDistance()+1);
                    v.setPredecessor(u);
                    naryTree.insertNode(v.getValue(),v.getPredecessor().getValue());
                    queue.add(v);
                }
            }
            u.setColor(Color.BLACK);

        }
        return naryTree;
    }

    @Override
    public ArrayList<NaryTree<V>> DFS() {
        ArrayList<NaryTree<V>> naryTrees = new ArrayList<>();
        for (Vertex<V> u: vertexList) {
            u.setColor(Color.WHITE);
            u.setPredecessor(null);
        }
        time = 0;
        for (Vertex<V> u: vertexList) {
            if (u.getColor() == Color.WHITE){
                NaryTree<V> naryTree = new NaryTree<>();
                naryTree.setRoot(new Node<V>(u.getValue()));
                DFSV(u, naryTree);
                naryTrees.add(naryTree);
                
            }
        }

        return naryTrees;
    }
    @Override
    public void DFSV(Vertex<V> u, NaryTree<V> n) {
        time += 1;
        u.setDistance(time);
        u.setColor(Color.GRAY);
        for (Vertex<V> v: u.getAdjacencyList()){
            if(v.getColor() == Color.WHITE){
                v.setPredecessor(u);
                n.insertNode(v.getValue(), u.getValue());
                DFSV(v,n);
            }
        }
        u.setColor(Color.BLACK);
        time = time + 1;
    }
}
