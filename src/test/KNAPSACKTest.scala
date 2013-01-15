package test

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import subsets._

@RunWith(classOf[JUnitRunner])
class KNAPSACKTest extends FunSuite{

  class Greedy extends KNAPSACKProblem with KNAPSACKInstance
  class SubS extends SubsetsKNAPSACK with KNAPSACKProblem with KNAPSACKInstance
  class SubSown extends OwnSubsetsKNAPSACK with KNAPSACKProblem with KNAPSACKInstance
  class SimBack extends SimpleBacktracking with KNAPSACKProblem with KNAPSACKInstance
  class DynProg extends DynamicProgramming with KNAPSACKProblem with KNAPSACKInstance
  
  val greedy= new Greedy
  val subs= new SubS
  val ownsubs= new SubSown
  val simback= new SimBack
  val dynprog= new DynProg
  
  test("Test der Funktion getValues"){
	  val x=greedy.getValues(Set(0,1,2,3,4,5,6))
	  assert(x===(44,36))
	}
  
  test("Test der Funktion sumGain"){
	  val x=greedy.sumGain(List((2,0.5), (1,1.0), (0,1.0)))
	  assert(x===15)
	}
  
  test("Test des Greedy-Algorithmus"){
	  val (x,y)=greedy.findGreedyOptimum(Set(0,4,5,6,7,8,9,10),9)
	  assert(y===24.8)
	}
  
  test("Findung des Optimums - 10 Elemente - Klasse SubsetsKNAPSACK"){
    val (x,y,z)= subs.findOptimum(Set(0,1,2,3,4,5,6,7,8,9),29)
    assert(x===38)
  }
  
  test("Findung des Optimums - 10 Elemente - Klasse OwnSubsetsKNAPSACK"){
    val (x,y,z)= ownsubs.findOptimum(Set(0,1,2,3,4,5,6,7,8,9),29)
    assert(x===38)
  }
  
  test("Findung des Optimums - 10 Elemente - Klasse SimpleBacktracking"){
    val (x,y,z)=simback.findOptimum((0 until 10).toSet,29)
    assert((x=== 38))
  }
  
  test("Findung des Optimums - 10 Elemente - Klasse Dynamic Programming"){
    val (x,y,z)=simback.findOptimum((0 until 10).toSet,29)
    assert((x=== 38))
  }
  
  test("Findung des Optimums - 20 Elemente - Klasse SubsetsKNAPSACK"){
    val (x,y,z)=subs.findOptimum((0 until 20).toSet,29)
    assert((x== 113))
  }
  
  test("Findung des Optimums - 20 Elemente - Klasse OwnSubsetsKNAPSACK"){
    val (x,y,z)=ownsubs.findOptimum((0 until 20).toSet,29)
    assert((x== 113))
  }

  test("Findung des Optimums - 20 Elemente - Klasse SimpleBacktracking"){
    val (x,y,z)=simback.findOptimum((0 until 20).toSet,29)
    assert((x== 113))
  }
    test("Findung des Optimums - 20 Elemente - Klasse Dynamic Programming"){
    val (x,y,z)=dynprog.findOptimum((0 until 20).toSet,29)
    assert((x=== 113))
  }

  test("Findung des Optimums - 25 Elemente - Klasse SubsetsKNAPSACK"){
    val (x,y,z)=subs.findOptimum((0 until 25).toSet,29)
    assert(x===153)
    }
 
  test("Findung des Optimums - 25 Elemente - Klasse OwnSubsetsKNAPSACK"){
    val (x,y,z)=ownsubs.findOptimum((0 until 25).toSet,29)
    assert(x===153)
    }
  
    test("Findung des Optimums - 25 Elemente - Klasse SimpleBacktracking"){
    val (x,y,z)=simback.findOptimum((0 until 25).toSet,150)
    assert(x===303)
    }

    test("Findung des Optimums - 25 Elemente - Klasse Dynamic Programming"){
    val (x,y,z)=dynprog.findOptimum((0 until 25).toSet,150)
    assert(x===303)
    }

    test("Findung des Optimums - 30 Elemente - Klasse SimpleBacktracking"){
    val (x,y,z)=simback.findOptimum((0 until 30).toSet,300)
    assert(x===418)
  }

   test("Findung des Optimums - 30 Elemente - Klasse DynamicProgramming"){
    val (x,y,z)=dynprog.findOptimum((0 until 30).toSet,300)
    assert(x===418)
  }

   test("Findung des Optimums - 40 Elemente - Klasse DynamicProgramming"){
    val (x,y,z)=dynprog.findOptimum((0 until 40).toSet,600)
    assert(x===854)
  }
}
  