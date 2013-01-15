package subsets
import common._

trait SimpleBacktracking {

  val items:Array[(Int,Int)]
  def getValues(configuration:Set[Int]):(Int,Int)  	
  def sumGain(sol:List[(Int, Double)]):Double
  var sortedItems:Array[(Int,(Int,Int),Double)]
  def sortItems(itemlist:Set[Int]):Unit
 
  // Calculates the Optimum by using backtracking
  def findOptimum(itemlist:Set[Int], capacity:Int):(Int, Int, Set[Int])= ??? 
}