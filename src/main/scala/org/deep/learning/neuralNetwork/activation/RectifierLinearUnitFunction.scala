package org.deep.learning.neuralNetwork.activation

object RectifierLinearUnitFunction {

  def apply(): RectifierLinearUnitFunction = new RectifierLinearUnitFunction()
}

class RectifierLinearUnitFunction extends ActivationFunction {

  def activate(value: BigDecimal): BigDecimal = {
    if (value > 0 )
      value
    else
      0
  }

  def derivative(value: BigDecimal): BigDecimal = {
    if (value > 0)
      1
    else
      0
  }

}
