package scalaHello

import com.typesafe.scalalogging.LazyLogging

class ArrayMath(a: Array[Int]) extends LazyLogging {
  def square(): Seq[Int] = {
    return a.map(i => i * i)
  }

  def even = a.filter(_ % 2 == 0)

  def odd = a.filter(_ % 2 == 1)

  def sum: Int = a.foldLeft(0)(_ + _)

  def product: Int = a.foldLeft(1)(_ * _)

  def stdDev: Double = {
    val mean = a.foldLeft(0.0)(_ + _) / a.length
    val sqaureErrors = a.map(_ - mean).map(i => i*i)
    math.sqrt(sqaureErrors.foldLeft(0.0)(_ + _) / a.length)
  }
  def run: Unit = {
    logger.info("Original: " + a.mkString(" "))
    logger.info("Square: " + square.mkString(" "))
    logger.info("Even: " + even.mkString(" "))
    logger.info("Odd: " + odd.mkString(" "))
    logger.info(s"Sum: ${sum}")
    logger.info(s"Product: ${product}")
    logger.info(s"Std Dev: ${stdDev}")
  }
}
