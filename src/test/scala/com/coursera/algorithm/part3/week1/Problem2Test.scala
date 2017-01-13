package com.coursera.algorithm.part3.week1

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sunilpatil on 1/6/17.
  */
class Problem2Test extends FlatSpec with Matchers{
  "Problem2 " should "schedule jobs in correct order for 2 jobs" in {
    val jobs = new Array[Job2](2)
    jobs(1) = new Job2(5,3)
    jobs(0) = new Job2(2,1)

    val weightedSum =Problem2.calculateWeightedSum(jobs)
    assert(weightedSum == 22)
  }

  "Problem2 " should "schedule jobs in correct order for 4 jobs with same length and weight " in {
    val jobs = new Array[Job2](4)
    jobs(0) = new Job2(1,97)
    jobs(1) = new Job2(1,97)
    jobs(2) = new Job2(1,97)
    jobs(3) = new Job2(1,97)

    val weightedSum =Problem2.calculateWeightedSum(jobs)
    assert(weightedSum == 970)
  }
}
