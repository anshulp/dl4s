package org.deep.learning.neuralNetwork

import org.deep.learning.neuralNetwork.activation.ActivationFunction
import breeze.linalg.DenseMatrix

object Layer {

  def apply(
    layerId: Int,
    numberOfNeurons: Int,
    activationFunction: ActivationFunction,
    previousLayer: Option[Layer] = None,
    weightMatrix: Option[DenseMatrix[Double]] = None,
    inputFeatureValues: Option[List[BigDecimal]] = None): Layer = {

    assert(numberOfNeurons > 0, "Number of neurons in the layer cannot be less than one.")
    assert(activationFunction != null, "ActivationFunction should not be null.")
    assert({
      !(previousLayer.isEmpty && weightMatrix.nonEmpty) &&
        !(previousLayer.nonEmpty && weightMatrix.isEmpty)
    }, "if previousLayer is none, weight matrix should also be none.")

    if (inputFeatureValues.isDefined)
      assert(numberOfNeurons == inputFeatureValues.get.size, "Input vector should be of the same size as numberOfNeurons in the layer.")

    new Layer(
      layerId = layerId,
      numberOfNeurons = numberOfNeurons,
      inputFeatureValues = inputFeatureValues,
      previousLayer = previousLayer,
      weightMatrix = weightMatrix,
      activationFunction = activationFunction)
  }
}

class Layer(
  layerId: Int,
  numberOfNeurons: Int,
  activationFunction: ActivationFunction,
  previousLayer: Option[Layer],
  weightMatrix: Option[DenseMatrix[Double]],
  inputFeatureValues: Option[List[BigDecimal]]) {

  // TODO: Need to introduce weights in here
  private lazy val inputValuesFromPreviousLayersNeurons: List[BigDecimal] = {
    if (previousLayer.isDefined && weightMatrix.isDefined) {
      val previousLayerNeurons = previousLayer.get.neurons
      (0 to numberOfNeurons-1).map(currentNeuronIndex => {
        (0 to previousLayerNeurons.size-1).map(previousNeuronIndex =>
          previousLayerNeurons(previousNeuronIndex).output * weightMatrix.get.valueAt(previousNeuronIndex, currentNeuronIndex)).sum
      }).toList
    }
    else
      List.fill(0)(numberOfNeurons)
  }

  // if inputFeatureValues are defined, i.e. for Ist layer then use it, else compute it from previous layer
  private def input(neuronIndex: Int): BigDecimal =
    inputFeatureValues.filterNot(_.isEmpty).getOrElse(inputValuesFromPreviousLayersNeurons)(neuronIndex)

  // Build layer of Neurons
  // TODO - Add a bias neuron
  lazy val neurons: List[Neuron] =
    (0 to numberOfNeurons-1).map(index =>
      Neuron(
        input = input(index),
        activationFunction = activationFunction)).toList

  lazy val output: List[BigDecimal] = neurons.map(_.output)
}
