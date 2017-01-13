package com.coursera.algorithm.part3.week1

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * Created by sunilpatil on 1/12/17.
  */
class GraphDFSSearch(graph: AdjancyListDirectedGraph) {

  def search( source: String, target: String): Boolean = {
    val connected = new mutable.HashSet[Vertex]()
    val stack = new Stack[Vertex](1000)
    val t = graph.getVertex(target)
    stack.push(graph.getVertex(source))
    connected.add(graph.getVertex(source))
    while (!stack.empty()) {
      val currentVertext = stack.pop()
      if (currentVertext.equals(t))
        return true
      println("Processing edge " + currentVertext)
      val edgeList = currentVertext.edges

      edgeList.foreach(edge => {
        val targetVertex = edge.target
        if (!connected.contains(targetVertex)) {
          stack.push(targetVertex)
          connected.add(targetVertex)
        }
      })
    }
    false
  }

  def searchRecursive(source: String, target: String): Boolean = {
    val connected = new mutable.HashSet[Vertex]()
    val sourceVertex = graph.getVertex(source)
    val targetVertex = graph.getVertex(target)
    connected.add(sourceVertex)
    searchRecursive(sourceVertex,targetVertex,connected)
  }

  def searchRecursive(sourceVertex: Vertex, targetVertex: Vertex, connected: mutable.HashSet[Vertex]): Boolean ={
    if(sourceVertex == targetVertex)
      return true

    val edgeList = sourceVertex.edges
    edgeList.foreach( edge => {
      val currentVertex = edge.target
      if(!connected.contains(currentVertex)){
        if(searchRecursive(currentVertex,targetVertex, connected))
          return true
        connected.add(currentVertex)
      }
    })

    false
  }
}
