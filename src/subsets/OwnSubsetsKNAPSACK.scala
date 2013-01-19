package subsets
import common._

trait OwnSubsetsKNAPSACK {

  val items:Array[(Int,Int)]
  def getValues(configuration:Set[Int]):(Int,Int)  	
  def sumGain(sol:List[(Int, Double)]):Double

  // Calculates the optimum by implementing subsets on your own
  def findOptimum(items:Set[Int], capacity:Int):(Int, Int, Set[Int])= {
    var max = (0,0,Set(0))
    println(subsetsOwn(items))
//    subsetsOwn(items).foreach(perm => {val prof = getValues(perm); if(prof._1 > max._1 && capacity >= prof._2) max = (prof._1,prof._2, perm)})
    max
  }

  def subsetsOwn(items:Set[Int]):Set[Set[Int]]= {
    def innerSubsetsOwn(items:Set[Int], perms:Set[Set[Int]]):Set[Set[Int]] = {
      if (!items.isEmpty)
    	  innerSubsetsOwn(items.tail, perms++Set(Set(items.head)))
      else
        perms
    }
    innerSubsetsOwn(items,Set())++Set.empty
  }

}