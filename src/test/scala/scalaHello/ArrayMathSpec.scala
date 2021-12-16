package scalaHello

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers._
import scala.math.sqrt

class ArrayMathSpec extends AnyFunSpec {
    val am = new ArrayMath(Array(1, 2, 3, 4, 5))
    describe("Array Math") {
        it("should square each element") {
            // This uses a should Matcher
            am.square should equal (Array(1, 4, 9, 16, 25))
        }
        it("should filter evens") {
            am.even should equal (Array(2, 4))
        }
        it("should filter odds") {
            am.odd should equal (Array(1, 3, 5))
        }
        it("should sum correctly") {
            assert(am.sum == 15)
        }
        it("should multiply correctly") {
            assert(am.product == 120)
        }
        it("should calculate a standard deviation") {
            am.stdDev should equal (sqrt(2) +- 1e-8)
        }
    }
}