package com.coursera.algorithm.part3.week1

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/**
  * Created by sunilpatil on 1/7/17.
  */
class AdjancyListDirectedGraph(noOfVertex:Int) {
  var vertexList: mutable.ArrayBuffer[Vertex] = new mutable.ArrayBuffer[Vertex]()
  var vertexMap: mutable.Map[String, Vertex] = new mutable.HashMap[String, Vertex]()

  def addVertex(label:String): Unit ={
    val vertex = new Vertex(label)
    vertexList += vertex
    vertexMap.put(label,vertex)
  }

  def containsVertex(label:String):Boolean={
    vertexMap.contains(label)
  }


  def addEdge(sourceLabel: String, targetLabel: String, weight:Int ): Unit ={
    addEdge(getVertex(sourceLabel), getVertex(targetLabel), weight)
  }

  def getVertex(label: String): Vertex={
    var vertex = vertexMap.getOrElse(label,null)
    if(vertex == null){
      vertex = new Vertex(label)
      vertexMap.put(label, vertex)
    }
    vertex
  }

  def addEdge(sourceLabel: String, targetLabel: String): Unit = {
    addEdge(sourceLabel,targetLabel,0)
  }

    def addEdge(sourceVertex: Vertex, targetVertex: Vertex, weight:Int): Unit ={
    sourceVertex.edges += new Edge(sourceVertex,targetVertex,weight)
  }

}

class Vertex(n:String){
  val name:String = n
  val edges: ArrayBuffer[Edge] = new mutable.ArrayBuffer[Edge] ()

  override def toString = s"Vertex($name)"
}

class Edge(s:Vertex, t:Vertex, w: Int){
  val source:Vertex = s
  val target:Vertex = t
  val weight:Int =  w

  override def toString = s"Edge($source, $target, $weight)"
}
