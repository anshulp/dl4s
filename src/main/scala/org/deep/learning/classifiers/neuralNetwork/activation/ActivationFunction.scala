package org.deep.learning.classifiers.neuralNetwork.activation

trait ActivationFunction {

  def activate(value: BigDecimal): BigDecimal

  def derivative(value: BigDecimal): BigDecimal

}
