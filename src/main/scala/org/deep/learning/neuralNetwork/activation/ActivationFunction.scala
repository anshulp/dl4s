package org.deep.learning.neuralNetwork.activation

trait ActivationFunction {

  def activate(value: BigDecimal): BigDecimal

  def derivative(value: BigDecimal): BigDecimal

}
