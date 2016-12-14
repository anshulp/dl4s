package org.deep.learning.neuralNetwork.network.supervised

import breeze.linalg.DenseMatrix
import org.deep.learning.neuralNetwork.network.NeuralNetwork
import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.RectifierLinearUnitFunction
import org.deep.learning.neuralNetwork.network.supervised.MultiLayerPerceptron._

object MultiLayerPerceptron {

  private val ReLU = RectifierLinearUnitFunction()

  def apply(
    numberOfLayers: Int,
    numberOfNeuronsPerLayer: Int,
    mapOfWeightMatrices: Map[Int, DenseMatrix[Double]],
    inputFeatureValues: Option[List[BigDecimal]] = None): MultiLayerPerceptron =

      new MultiLayerPerceptron(
        numberOfLayers = numberOfLayers,
        numberOfNeuronsPerLayer = numberOfNeuronsPerLayer,
        mapOfWeightMatrices = mapOfWeightMatrices,
        inputFeatureValues = inputFeatureValues)
}

class MultiLayerPerceptron(
  numberOfLayers: Int,
  numberOfNeuronsPerLayer: Int,
  mapOfWeightMatrices: Map[Int, DenseMatrix[Double]],
  inputFeatureValues: Option[List[BigDecimal]]) extends NeuralNetwork {

  private val inputLayer: Layer = Layer(
    layerId = 0,
    numberOfNeurons = numberOfNeuronsPerLayer,
    activationFunction = ReLU,
    inputFeatureValues = inputFeatureValues)

  // TODO: make this val - cyclic datastructure
  private var tempLayer = inputLayer

  val tempLayers = for {
    layerId <- 1 to numberOfLayers-1
  } yield {
    val layer = Layer(
      layerId = layerId,
      numberOfNeurons = numberOfNeuronsPerLayer,
      activationFunction = ReLU,
      weightMatrix = Some(mapOfWeightMatrices(layerId)),
      previousLayer = Some(tempLayer))
    tempLayer = layer
    layer
  }

  val layers = List(inputLayer) ++ tempLayers.toList

  lazy val output = layers.last.output

}
