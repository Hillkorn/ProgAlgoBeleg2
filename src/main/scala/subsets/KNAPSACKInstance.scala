package subsets

trait KNAPSACKInstance{

  // Description of the items
  // (profit, weight)
  val items:Array[(Int,Int)]= Array((6,2), (5,3), (8,6), (9,7), (6,5), (7,9), (3,4), (10,23), (9,12), (10,11),
		  							(14,3), (17,2), (11,9), (22,4), (23,5), (2,17), (17,2), (11,25),(33,17), (22,88),
		  							(17,5), (18,3), (19,6), (22,17), (25,5), (27,9), (32,44), (17,99),(11,23), (24,11),
		  							(28,22),(12,2),(17,5),(120,22),(73,23), (16,2), (26,66), (23,11), (23,5), (88,100))

}
