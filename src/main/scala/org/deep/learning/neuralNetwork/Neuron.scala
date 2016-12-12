package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.ActivationFunction

object Neuron {

  // TODO we will weights here too for the calculation
  /***
    * @param input - input vector for this neuron. For the first later, input vector may be of size = 1
    * @param activationFunction - which activation function to use for calculation
    * @return
    */
  def apply(
    input: BigDecimal,
    activationFunction: ActivationFunction): Neuron = {

    new Neuron(
      input = input,
      activationFunction = activationFunction)
  }
}

class Neuron(
  val input: BigDecimal,
  activationFunction: ActivationFunction){

  lazy val output: BigDecimal = activationFunction.activate(input)

  lazy val derivative: BigDecimal = activationFunction.derivative(input)

  lazy val forwardLinks: List[Link] = List.empty // TODO: implement this

}
