object foobar {
  def main(args: Array[String]) = {
    val init_values = List.range(1, 101)
    val result = init_values.map(qix)
    for ( (i, qix_i)<- init_values.zip(result) ) println (i+" "+qix_i)
  }
  def qix(n:Int):String={
    var n_in_cifers = n.toString.toList.map(_.toString.toInt)
    val contained = for (cifer <- n_in_cifers;
		       x <- cifers_to_test
		       if cifer == x ) yield yell(x)
    val dividers = for (x <- cifers_to_test
		       if n % x == 0 ) yield yell(x)
    val result = contained:::dividers
    result match {
      case List() => n.toString
      case l => l.mkString ("")
    }
  }
  val yell=Map ( 3 -> "Foo",
		 5 -> "Bar",
		 7 -> "Qix" )
  val cifers_to_test = List (3,5,7)
}
