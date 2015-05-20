package coursera

object rational_number {
  class Rational(x: Int, y: Int) {
    private val g = gcd(x, y)

    val numerator = x / g
    val denominator = y / g
    
    override def toString = s"$numerator / $denominator"
    
    def add(other: Rational) =
      new Rational(
        numerator * other.denominator + other.numerator * denominator,
        denominator * other.denominator)
        
    def sub(other: Rational) = add(other.neg)
        
    def mul(other: Rational) =
      new Rational(
        numerator * other.numerator,
        denominator * other.denominator)
      
    def neg = new Rational(-numerator, denominator)
    
    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  }
  
  val x = new Rational(1, 3)                      //> x  : coursera.rational_number.Rational = 1 / 3
  val y = new Rational(5, 7)                      //> y  : coursera.rational_number.Rational = 5 / 7
  val z = new Rational(3, 2)                      //> z  : coursera.rational_number.Rational = 3 / 2
  
  x.add(y).mul(z)                                 //> res0: coursera.rational_number.Rational = 11 / 7
  x.sub(y).sub(z)                                 //> res1: coursera.rational_number.Rational = -79 / 42
  
  y.add(y)                                        //> res2: coursera.rational_number.Rational = 10 / 7
}