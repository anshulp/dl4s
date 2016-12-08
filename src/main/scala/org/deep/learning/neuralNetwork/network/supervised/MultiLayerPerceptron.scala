package org.deep.learning.neuralNetwork.network.supervised

import org.deep.learning.neuralNetwork.network.NeuralNetwork
import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.{ActivationFunction, RectifierLinearUnitFunction}

object MultiLayerPerceptron {

  def apply(
    numberOfLayers: Int,
    numberOfNeuronsPerLayer: Int,
    activationFunction: ActivationFunction,
    inputValues: Option[List[BigDecimal]] = None): MultiLayerPerceptron =
      new MultiLayerPerceptron(
        numberOfLayers = numberOfLayers,
        numberOfNeuronsPerLayer = numberOfNeuronsPerLayer,
        activationFunction = activationFunction,
        inputValues = inputValues)
}

class MultiLayerPerceptron(
  numberOfLayers: Int,
  numberOfNeuronsPerLayer: Int,
  activationFunction: ActivationFunction,
  inputValues: Option[List[BigDecimal]]) extends NeuralNetwork {

  // Layers have to feed forwrad to next layer
  val layers: List[Layer] = (0 to numberOfLayers).map(layerId =>
    Layer(numberOfNeuronsPerLayer, activationFunction, inputValues)).toList

  lazy val output = layers.last.output

}
