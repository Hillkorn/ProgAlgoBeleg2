package subsets
import common._

trait SubsetsKNAPSACK{

  val items:Array[(Int,Int)]
  def getValues(configuration:Set[Int]):(Int,Int)  	
  def sumGain(sol:List[(Int, Double)]):Double

  // calculates the Optimum by using the subsets method of the class subset
  def findOptimum(items:Set[Int], capacity:Int):(Int, Int, Set[Int])= {
    var max = (0,0,Set(0))
    items.subsets.foreach(perm => {val prof = getValues(perm); println(prof+" => "+perm); if(prof._1 > max._1 && capacity >= prof._2) max = (prof._1,prof._2, perm)})
    max
  }
  
}
