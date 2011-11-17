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
    val result = dividers:::contained
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

object foobar_test {
  def main(args: Array[String]) = tests

  def tests={
    val cases=Map(3 -> "FooFoo",
		  4 -> "4",
		  7 -> "QixQix",
		  13 -> "Foo",
		  15 -> "FooBarBar",
		  33 -> "FooFooFoo",
		  51 -> "FooBar",
		  53 -> "BarFoo",
		  64 -> "64",
		  21 -> "FooQix")
    for ( (input, expected) <- cases ) { 
      assert (foobar.qix(input)==expected, "Fail for "+input+". Exp="+expected + " result="+foobar.qix(input)) 
    }
    println ("ok")
  }
}

