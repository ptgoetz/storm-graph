package com.github.ptgoetz.storm.graph.state;

import java.util.Map;

import com.tinkerpop.blueprints.Graph;

/**
 * Interface for factory classes that can produce <code>Graph</code> instances.
 */
public interface GraphFactory {
    /**
     * Given a storm <code>Config</code> object, connect to or instantiate
     * a <code>Graph</code> database.
     *
     * @param conf
     * @return
     */
    public Graph makeGraph(Map conf);
}
