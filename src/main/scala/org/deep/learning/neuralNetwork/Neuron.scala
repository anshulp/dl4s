package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.ActivationFunction

object Neuron {

  // TODO we will weights here too for the calculation
  def apply(
    input: List[BigDecimal],
    activationFunction: ActivationFunction): Neuron = {

    new Neuron(
      input = input,
      activationFunction = activationFunction)
  }
}

class Neuron(
  val input: List[BigDecimal],
  activationFunction: ActivationFunction){

  lazy val output: List[BigDecimal] = List.empty // TODO: implement this, output vector for each weight

  lazy val forwardLinks: List[Link] = List.empty // TODO: implement this



}
