package subsets
import common._

trait KNAPSACKProblem {

  // Items - Defined in KNAPSACKInstance
  val items:Array[(Int,Int)] 

  
  // Sorted Version of the Items
  // Elements structure: (indexOfOrigin,(profit, weight), profit/weight-ratio)
  var sortedItems:Array[(Int,(Int,Int),Double)] = Array()
  
  
  // sums the values of a given itemlist
  // returns the sum of (profit, weight)
  def getValues(configuration:Set[Int]):(Int,Int)= 
    	configuration.foldLeft((0,0))((X,Y)=>(X._1 + items(Y)._1, X._2 + items(Y)._2))
  
  
   // sums the profit of a List of items connected with a quota (determined by greedy)
   // input: List(itemIndex, quota)
  def sumGain(sol:List[(Int, Double)]):Double = sol match {
    
    case Nil => 0
    case x::xs => items(x._1)._1*x._2.toDouble + sumGain(xs) 
  }
  
  
  // transforms a set (describe by indices) of items into a tuple (described above)
  // sorts the items by the ratio profit/weight
  def sortItems(itemlist:Set[Int]):Unit= {
    def sortItemsInner(itemlistInner:Set[Int]):List[(Int,(Int,Int),Double)] = {
	    if(itemlistInner.size == 1) {
	      List((itemlistInner.head, (items(itemlistInner.head)._1, items(itemlistInner.head)._2),items(itemlistInner.head)._1.toDouble/items(itemlistInner.head)._2))
	    } else {
	      sortItemsInner(itemlistInner.filter(x => items(x)._1/items(x)._2 < items(itemlistInner.head)._1/items(itemlistInner.head)._2))++List((itemlist.head, (items(itemlistInner.head)._1, items(itemlistInner.head)._2),items(itemlist.head)._1.toDouble/items(itemlist.head)._2.toDouble))++sortItemsInner(itemlist.filter(x => items(x)._1/items(x)._2 >= items(itemlist.head)._1/items(itemlist.head)._2))
	    }
    }
    sortedItems = sortItemsInner(itemlist).toArray
  }

  // calculates the greedy-Optimum
  def findGreedyOptimum(itemlist:Set[Int], capacity:Int):(Set[(Int, Double)], Double)= ???
}
