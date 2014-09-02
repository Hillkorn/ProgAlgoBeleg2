package subsets
import common._
import com.sun.xml.internal.bind.v2.TODO

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
      sortedItems = Array()
      itemlist.foreach { index =>
          sortedItems = sortedItems :+ (index,(items(index)._1,items(index)._2), items(index)._1/items(index)._2.toDouble)
      }
      sortedItems = sortedItems.sortWith((x,y) => (x._3 > y._3))
  }

  def findGreedyOptimum(itemlist:Set[Int], capacity:Int):(Set[(Int, Double)], Double)= {
      sortItems(itemlist)
      var r:List[(Int, Double)] = List()
      var c = capacity
      sortedItems.foreach { element =>
          if(element._2._2 < c) {
                r = (element._1, 1.0)::r
                c -= element._2._2
          } else {
               r = (element._1, c/element._2._2.toDouble)::r
               return (r.toSet, sumGain(r))
          }       
      }
      return (r.toSet, 0.0)
  }
}