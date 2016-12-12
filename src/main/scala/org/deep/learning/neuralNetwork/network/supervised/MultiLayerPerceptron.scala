package org.deep.learning.neuralNetwork.network.supervised

import org.deep.learning.neuralNetwork.network.NeuralNetwork
import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.RectifierLinearUnitFunction
import org.deep.learning.neuralNetwork.network.supervised.MultiLayerPerceptron._

object MultiLayerPerceptron {

  private val ReLU = RectifierLinearUnitFunction()

  def apply(
    numberOfLayers: Int,
    numberOfNeuronsPerLayer: Int,
    inputValues: Option[List[BigDecimal]] = None): MultiLayerPerceptron =
      new MultiLayerPerceptron(
        numberOfLayers = numberOfLayers,
        numberOfNeuronsPerLayer = numberOfNeuronsPerLayer,
        inputValues = inputValues)
}

class MultiLayerPerceptron(
  numberOfLayers: Int,
  numberOfNeuronsPerLayer: Int,
  inputValues: Option[List[BigDecimal]]) extends NeuralNetwork {

  private val inputLayer: Layer = Layer(
    layerId = 0,
    numberOfNeurons = numberOfNeuronsPerLayer,
    activationFunction = ReLU,
    inputValues = inputValues)

  // TODO: make this val - cyclic datastructure
  var tempLayer = inputLayer

  val tempLayers = for {
    layerId <- 1 to numberOfLayers-1
  } yield {
    val layer = Layer(layerId = layerId, numberOfNeurons = numberOfNeuronsPerLayer, activationFunction = ReLU, previousLayer = Some(tempLayer))
    tempLayer = layer
    layer
  }

  val layers = List(inputLayer) ++ tempLayers.toList

  lazy val output = layers.last.output

}
