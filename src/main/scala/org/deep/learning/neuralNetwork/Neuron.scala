package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.ActivationFunction

object Neuron {

  def apply(input: BigDecimal,
            activationFunction: ActivationFunction): Neuron = {

    new Neuron(
      input = input,
      activationFunction = activationFunction)
  }
}

class Neuron(
  val input: BigDecimal,
  activationFunction: ActivationFunction){

  lazy val output: List[BigDecimal] = List.empty // TODO: implement this, output vector for each weight

  lazy val forwardLinks: List[Link] = List.empty // TODO: implement this

}
