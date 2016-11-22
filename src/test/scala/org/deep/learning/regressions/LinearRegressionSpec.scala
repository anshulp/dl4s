package org.deep.learning.regressions

import org.deep.learning.regressions.LinearRegression
import org.scalatest.{OptionValues, Matchers, FlatSpec}

class LinearRegressionSpec extends FlatSpec with Matchers with OptionValues {

  val x: Array[Int] = Array(1, 2)
  val y: Array[Int] = Array(1, 2)

  behavior of "LinearRegression"

  it should "correctly predict value for 'y' for given training set" in {
    val lr = LinearRegression(x, y)
    lr.predict(3, 0).prediction should be (3)
  }

}
