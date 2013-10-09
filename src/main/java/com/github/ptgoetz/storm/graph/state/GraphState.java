package com.github.ptgoetz.storm.graph.state;

import java.util.List;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.TransactionalGraph;

import storm.trident.operation.TridentCollector;
import storm.trident.state.State;
import storm.trident.tuple.TridentTuple;

/**
 * Trident <code>State</code> implementation that modifies a <code>Graph</code> database.
 * <p/>
 * If the underlying <code>Graph</code> implementation supports transactions, the
 * the <code>TransactionalGraph.commit()</code> method will be called when a
 * batch partition has sucsessfully been processed.
 *
 */
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
