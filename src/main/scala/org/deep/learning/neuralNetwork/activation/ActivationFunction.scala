package org.deep.learning.neuralNetwork.activation

trait ActivationFunction {

  def activate(values: BigDecimal): BigDecimal

  def derivative(value: BigDecimal): BigDecimal

}
