package org.deep.learning.classifiers.neuralNetwork.activation

class SigmoidActivation extends ActivationFunction {

  def activate(value: BigDecimal): BigDecimal = {
    1 / (1 + math.exp(-1 * value.doubleValue()))
  }

  def derivative(value: BigDecimal): BigDecimal = {
    val ex = math.exp(-1 * value.doubleValue())
    val denom = 1 + ex

    (-1 * ex) / (denom * denom)
  }

}
