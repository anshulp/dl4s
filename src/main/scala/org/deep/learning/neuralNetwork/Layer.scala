package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.{ActivationFunction, RectifierLinearUnitFunction}

object Layer {

  /***
    *
    * @param numberOfNeurons
    * @param activationFunction - What activationFunction to use when Neuron calculates the output
    * @param inputValues - inputVector feeding into this layer. This is basically a matrix, i.e. a vector input for each neuron.
    *                    The matrix size should be - previousLayerNeurons x numberOfNeurons
    */
  /***
    *
    * @param layerId - layerId, for debugging purposes
    * @param numberOfNeurons - numberOfNeurons in this layer
    * @param activationFunction - What activationFunction to use when Neuron calculates the output
    * @param previousLayer - previous layer in the sequence
    * @param inputValues - inputVector feeding into this layer. This would be features for Ist layer and output of previousLayer for hidden + output layers
    * @return
    */
  def apply(
    layerId: Int,
    numberOfNeurons: Int,
    activationFunction: ActivationFunction,
    previousLayer: Option[Layer] = None,
    inputValues: Option[List[BigDecimal]] = None): Layer = {

    assert(numberOfNeurons > 0, "Number of neurons in the layer cannot be less than one.")
    assert(activationFunction != null, "ActivationFunction should not be null.")

    if (inputValues.isDefined)
      assert(numberOfNeurons == inputValues.get.size, "Input vector should be of the same size as numberOfNeurons in the layer.")

    new Layer(
      layerId = layerId,
      numberOfNeurons = numberOfNeurons,
      inputValues = inputValues,
      previousLayer = previousLayer,
      activationFunction = activationFunction)
  }
}

class Layer(
  val layerId: Int,
  val numberOfNeurons: Int,
  val activationFunction: ActivationFunction,
  val previousLayer: Option[Layer],
  val inputValues: Option[List[BigDecimal]]) {

  // TODO: Need to introduce weights in here
  private lazy val sumOfValuesFromPreviousLayersNeurons: BigDecimal =
    previousLayer.map(_.output.sum).getOrElse(0)

  // if inputValues are defined, i.e. for Ist layer then use it, else compute it from previous layer
  private lazy val inputToThisLayer: List[BigDecimal] =
    inputValues.filterNot(_.isEmpty).getOrElse(List.fill(numberOfNeurons)(sumOfValuesFromPreviousLayersNeurons))

  // Build layer of Neurons
  // TODO - Add a bias neuron
  lazy val neurons: List[Neuron] =
    (0 to numberOfNeurons-1).map(i => Neuron(inputToThisLayer(i), activationFunction)).toList

  lazy val output: List[BigDecimal] = neurons.map.(_.output)
}
