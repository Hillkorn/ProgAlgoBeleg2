package subsets
import common._

trait OwnSubsetsKNAPSACK {

  val items:Array[(Int,Int)]
  def getValues(configuration:Set[Int]):(Int,Int)  	
  def sumGain(sol:List[(Int, Double)]):Double

  // Calculates the optimum by implementing subsets on your own
  def findOptimum(items:Set[Int], capacity:Int):(Int, Int, Set[Int])= ???

  def subsetsOwn(items:Set[Int]):Set[Set[Int]]= ???

}