package test.datastructures;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import datastructures.Graph.Graph;
import datastructures.Graph.Color;
import datastructures.Graph.IGraph;
import datastructures.Graph.Vertex;



public class GraphTest {

    private Graph<String> graph;

    void setupStage1(){
        graph = new Graph<>(false);
    }
    void setupStage2(){
        graph = new Graph<>(false);

        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        Vertex<String> vertex3 = new Vertex<>("C");
        Vertex<String> vertex4 = new Vertex<>("D");
        Vertex<String> vertex5 = new Vertex<>("E");
        Vertex<String> vertex6 = new Vertex<>("F");
        Vertex<String> vertex7 = new Vertex<>("G");
        Vertex<String> vertex8 = new Vertex<>("H");
    }
    void setupStage3(){
        graph = new Graph<>(false);

        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        Vertex<String> vertex3 = new Vertex<>("C");
        Vertex<String> vertex4 = new Vertex<>("D");
        Vertex<String> vertex5 = new Vertex<>("E");
        Vertex<String> vertex6 = new Vertex<>("F");
        Vertex<String> vertex7 = new Vertex<>("G");
        Vertex<String> vertex8 = new Vertex<>("H");

        graph.insertVertex(vertex1);
        graph.insertVertex(vertex2);
        graph.insertVertex(vertex3);
        graph.insertVertex(vertex4);
        graph.insertVertex(vertex5);
        graph.insertVertex(vertex6);
        graph.insertVertex(vertex7);
        graph.insertVertex(vertex8);

        graph.insertEdge(vertex1, vertex2);
        graph.insertEdge(vertex1, vertex3);
        graph.insertEdge(vertex2, vertex4);
        graph.insertEdge(vertex2, vertex5);
        graph.insertEdge(vertex3, vertex6);
        graph.insertEdge(vertex3, vertex7);

    }

}