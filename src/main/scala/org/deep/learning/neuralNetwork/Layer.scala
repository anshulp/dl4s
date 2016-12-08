package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.{ActivationFunction, RectifierLinearUnitFunction}

object Layer {

  def apply(
    numberOfNeurons: Int,
    activationFunction: ActivationFunction,
    inputValues: Option[List[BigDecimal]] = None): Layer = {

    assert(numberOfNeurons < 1, "Number of neurons in the layer cannot be less than one.")
    assert(activationFunction != null, "ActivationFunction should not be null.")

    if (inputValues.isDefined)
      assert(numberOfNeurons == inputValues.size, "Input vector should be of the same size as numberOfNeurons in the layer.")

    new Layer(
      numberOfNeurons = numberOfNeurons,
      inputValues = inputValues,
      activationFunction = activationFunction)
  }
}

class Layer(
  numberOfNeurons: Int,
  activationFunction: ActivationFunction,
  inputValues: Option[List[BigDecimal]]) {

  val neurons: List[Neuron] =
    (0 to numberOfNeurons).map(i => Neuron(inputValues.get(i), RectifierLinearUnitFunction())).toList

  lazy val output: List[BigDecimal] = List.empty

  // val links: Vector[Vector[BigDecimal]]

  // Build a layer?
  // add a bias neuron



}
