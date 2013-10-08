package com.github.ptgoetz.storm.graph.state;

import java.util.Map;

import com.tinkerpop.blueprints.Graph;

import backtype.storm.task.IMetricsContext;
import storm.trident.state.State;
import storm.trident.state.StateFactory;

public class GraphStateFactory implements StateFactory {
    
    private GraphFactory factory;
    
    public GraphStateFactory(GraphFactory factory){
        this.factory = factory;
    }

    public State makeState(Map conf, IMetricsContext metrics, int partitionIndex, int numPartitions) {
        Graph graph = this.factory.makeGraph(conf);
        State state = new GraphState(graph);
        return state;
    }

}
