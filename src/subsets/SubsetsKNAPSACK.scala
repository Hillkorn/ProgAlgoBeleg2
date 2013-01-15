package subsets
import common._

trait SubsetsKNAPSACK{

  val items:Array[(Int,Int)]
  def getValues(configuration:Set[Int]):(Int,Int)  	
  def sumGain(sol:List[(Int, Double)]):Double

  // calculates the Optimum by using the subsets method of the class subset
  def findOptimum(items:Set[Int], capacity:Int):(Int, Int, Set[Int])= ???
  
}
