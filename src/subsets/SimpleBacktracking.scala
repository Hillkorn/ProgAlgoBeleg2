package subsets
import common._

trait SimpleBacktracking {

  val items: Array[(Int, Int)]
  def getValues(configuration: Set[Int]): (Int, Int)
  def sumGain(sol: List[(Int, Double)]): Double
  var sortedItems: Array[(Int, (Int, Int), Double)]
  def sortItems(itemlist: Set[Int]): Unit

  // Calculates the Optimum by using backtracking
//  def findOptimum(itemlist: Set[Int], capacity: Int): (Int, Int, Set[Int]) = {
//    def innerFindOptimum(itemList: Set[Int], tempResult: (Int, Int, Set[Int])): (Int, Int, Set[Int])= {
//      if (!itemList.isEmpty && tempResult._2 < capacity) {
//    	val sol = for (x <- itemList if(items(x)._2+tempResult._2 <= capacity)) yield innerFindOptimum(itemList-x, (tempResult._1+items(x)._1, tempResult._2+items(x)._2, tempResult._3+x))
//    	sol.foldLeft((0,0,Set(0)))((x,z) => if (x._1 > z._1) x else z)
//      } else {
//	    tempResult
//      }
//    }
//    innerFindOptimum(itemlist, (0, 0, Set()))
//  }
  def findOptimum(itemlist: Set[Int], capacity: Int): (Int, Int, Set[Int]) = {
    def innerFindOptimum(itemList: Set[Int], tempResult: (Int, Int, Set[Int])): (Int, Int, Set[Int])= {
      if (!itemList.isEmpty && tempResult._2 < capacity) {
        var restItems:Set[Int] = itemList
    	val sol = for (x <- itemList) yield { if(items(x)._2+tempResult._2 <= capacity) { restItems = restItems-x; innerFindOptimum(restItems, (tempResult._1+items(x)._1, tempResult._2+items(x)._2, tempResult._3+x)) } else { tempResult } }
    	sol.foldLeft((0,0,Set(0)))((x,z) => if (x._1 > z._1) x else z)
      } else {
        if (tempResult._1 > 400)
          println(tempResult)
	    tempResult
      }
    }
    val ret = innerFindOptimum(itemlist, (0, 0, Set()))
    println(ret)
    ret
  }
}