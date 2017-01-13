package com.coursera.algorithm.part3.week1

/**
  * Created by sunilpatil on 1/6/17.
  */
object Problem2 {

  def main(argv: Array[String]): Unit = {
    val jobs = readFile(argv(0)).sortWith((f, s) => f.score > s.score)
    println("Weighted Sum " +calculateWeightedSum(jobs))
  }

  def calculateWeightedSum(path: String): Long = {
    val jobs = readFile(path)
    calculateWeightedSum(jobs)
  }

  def calculateWeightedSum(jobs: Array[Job2]): Long = {
    val jobList = jobs.sortWith((f, s) => f.score > s.score)

    var weightedSum = 0L
    var completionTime = 0
    jobList.foreach(job =>{
      if(job != null){
        completionTime = completionTime + job.length
        weightedSum = weightedSum + completionTime * job.weight
      }
    })
    println("Returning weightedSum " + weightedSum)
    weightedSum
  }

  def readFile(path: String): Array[Job2] = {
    val jobsArray = new Array[Job2](10000)
    var counter = 0

    val linesIt = scala.io.Source.fromFile(path).getLines()

    linesIt.foreach(line => {
      if (line.split(" ").length == 2) {
        val tokens = line.split(" ")
        jobsArray(counter) = new Job2(tokens(0).toInt, tokens(1).toInt)
        counter = counter + 1
      }


    })
    jobsArray
  }


}

class Job2(l: Int, w: Int) {
  val length = l;
  val weight = w;

  val score = w.toDouble / l.toDouble

  override def toString = s"Job($length, $weight $score)"
}

