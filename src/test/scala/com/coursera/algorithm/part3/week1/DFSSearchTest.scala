package com.coursera.algorithm.part3.week1

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sunilpatil on 1/12/17.
  */
class DFSSearchTest extends FlatSpec with Matchers{

  "DFSSearch " should "should be able to search the connected components" in {
    val graph = new AdjancyListDirectedGraph(10)
    val search = new GraphDFSSearch(graph)

    graph.addEdge("1","2")
    graph.addEdge("1","3")
    graph.addEdge("2","4")
    graph.addEdge("2","3")
    graph.addEdge("3","5")
    graph.addEdge("4","5")
    graph.addEdge("4","6")
    graph.addEdge("5","6")

    graph.addEdge("8","9")
    assert(search.searchRecursive("1","5") )
  }

  "DFSSearch " should "should return for not connected edges" in {
    val graph = new AdjancyListDirectedGraph(10)
    val search = new GraphDFSSearch(graph)

    graph.addEdge("1","2")
    graph.addEdge("1","3")
    graph.addEdge("2","4")
    graph.addEdge("2","3")
    graph.addEdge("3","5")
    graph.addEdge("4","5")
    graph.addEdge("4","6")
    graph.addEdge("5","6")

    graph.addEdge("8","9")
    assert(search.searchRecursive("1","8") ==false)
  }
}
