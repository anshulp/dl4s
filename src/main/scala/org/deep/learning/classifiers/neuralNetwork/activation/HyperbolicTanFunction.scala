package org.deep.learning.classifiers.neuralNetwork.activation

class HyperbolicTanFunction extends ActivationFunction {

  def activate(value: BigDecimal): BigDecimal = {
    math.tanh(value.doubleValue())
  }

  def derivative(value: BigDecimal): BigDecimal = {
    val tanhValue = math.tanh(value.doubleValue())
    1 - (tanhValue * tanhValue)
  }

}