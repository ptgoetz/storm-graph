package com.github.ptgoetz.storm.graph.state;

import java.util.List;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.TransactionalGraph;

import storm.trident.operation.TridentCollector;
import storm.trident.state.State;
import storm.trident.tuple.TridentTuple;

public class GraphState implements State {
    
    private Graph graph;
    
    public GraphState(Graph graph){
        this.graph = graph;
    }

    public void beginCommit(Long txid) {}

    public void commit(Long txid) {
        if(this.graph instanceof TransactionalGraph){
            ((TransactionalGraph)this.graph).commit();
        }
    }
    
    public void update(List<TridentTuple> tuples, TridentCollector collector, GraphTupleProcessor processor){
        for(TridentTuple tuple : tuples){
            processor.process(this.graph, tuple, collector);
        }
    }

}
