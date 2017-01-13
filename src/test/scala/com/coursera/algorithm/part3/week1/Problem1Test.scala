package com.coursera.algorithm.part3.week1

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by sunilpatil on 1/6/17.
  * class Problem1Test extends FlatSpec with Matchers
  */
class Problem1Test extends FlatSpec with Matchers {

  "Problem1 " should "schedule jobs in correct order for 2 jobs" in {
    val jobs = new Array[Job](2)
    jobs(0) = new Job(5,3)
    jobs(1) = new Job(2,1)

    val weightedSum =Problem1.calculateWeightedSum(jobs)
    assert(weightedSum == 23)
  }

  "Problem1 " should "schedule jobs in correct order for 4 jobs with same length and weight " in {
    val jobs = new Array[Job](4)
    jobs(0) = new Job(1,97)
    jobs(1) = new Job(1,97)
    jobs(2) = new Job(1,97)
    jobs(3) = new Job(1,97)

    val weightedSum =Problem1.calculateWeightedSum(jobs)
    assert(weightedSum == 970)
  }

  "Problem1 " should " schedule jobs with same length and different weights" in {
    val jobs = new Array[Job](4)
    jobs(0) = new Job(4,3)
    jobs(1) = new Job(4,1)
    jobs(2) = new Job(4,2)
    jobs(3) = new Job(4,4)

    val weightedSum =Problem1.calculateWeightedSum(jobs)
    assert(weightedSum == 80)
  }
}
