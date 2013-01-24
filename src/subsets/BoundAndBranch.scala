package subsets

trait BoundAndBranch extends KNAPSACKProblem {

  val items: Array[(Int, Int)]
  def getValues(configuration: Set[Int]): (Int, Int)
  def sumGain(sol: List[(Int, Double)]): Double
  var sortedItems: Array[(Int, (Int, Int), Double)]
  def sortItems(itemlist: Set[Int]): Unit
  
  def findOptimum(outerItemlist: Set[Int], capacity: Int): (Int, Int, Set[Int]) = {
    var currentMax = 0
    def innerFindOptimum(innerItemList: Set[Int], restCapacity: Int, tempResult:(Int, Int, Set[Int])): (Int, Int, Set[Int]) = {
      if (restCapacity == 0) {
        if (currentMax < tempResult._1)
          currentMax = tempResult._1
        tempResult
      }
      var restItems:Set[Int] = innerItemList
      val optima = for (x <- innerItemList) yield {
        val res = (restItems, findGreedyOptimum(restItems, restCapacity)._2)
        restItems = restItems-x
        res
      }
      
      val sortedOptimum = optima.toList.sortWith((x,y) => (x._2 > y._2))
      if (!innerItemList.isEmpty && tempResult._2 < capacity) {
    	val sol = for (x <- sortedOptimum if(tempResult._1+x._2 > currentMax)) yield { if(items(x._1.head)._2+tempResult._2 <= capacity) { innerFindOptimum(x._1.tail, restCapacity-items(x._1.head)._2, (tempResult._1+items(x._1.head)._1, tempResult._2+items(x._1.head)._2, tempResult._3+x._1.head)) } else { tempResult } }
    	sol.foldLeft((0,0,Set(0)))((x,z) => if (x._1 > z._1) x else z)
      } else {
	    tempResult
      }
    }
    innerFindOptimum(outerItemlist, capacity, (0,0,Set(0)))
  }
}