package org.deep.learning.neuralNetwork.network.supervised

import breeze.linalg.DenseMatrix
import org.deep.learning.neuralNetwork.network.NeuralNetwork
import org.deep.learning.neuralNetwork.activation.RectifierLinearUnitFunction
import MultiLayerPerceptron._

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

  val layers = getLayers(
    numberOfLayers = numberOfLayers,
    numberOfNeuronsPerLayer = numberOfNeuronsPerLayer,
    mapOfWeightMatrices = mapOfWeightMatrices,
    inputFeatureValues = inputFeatureValues,
    activationFunction = ReLU)

  lazy val output = layers.last.output

}
