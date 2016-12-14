package org.deep.learning.neuralNetwork.network

import breeze.linalg.DenseMatrix
import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.ActivationFunction

trait NeuralNetwork {

  //https://www.toptal.com/machine-learning/an-introduction-to-deep-learning-from-perceptrons-to-deep-networks

  // Each Network is basically a List of layers
  // and produces a vector output

  def getLayers(
    numberOfLayers: Int,
    numberOfNeuronsPerLayer: Int,
    mapOfWeightMatrices: Map[Int, DenseMatrix[Double]],
    inputFeatureValues: Option[List[BigDecimal]],
    activationFunction: ActivationFunction): List[Layer] = {

    val inputLayer: Layer = Layer(
      layerId = 0,
      numberOfNeurons = numberOfNeuronsPerLayer,
      activationFunction = activationFunction,
      inputFeatureValues = inputFeatureValues)

    // TODO: make this val - cyclic datastructure
    var tempLayer = inputLayer

    val tempLayers = for {
      layerId <- 1 to numberOfLayers-1
    } yield {
      val layer = Layer(
        layerId = layerId,
        numberOfNeurons = numberOfNeuronsPerLayer,
        activationFunction = activationFunction,
        weightMatrix = Some(mapOfWeightMatrices(layerId)),
        previousLayer = Some(tempLayer))
      tempLayer = layer
      layer
    }

    List(inputLayer) ++ tempLayers.toList
  }

  val output: List[BigDecimal]


  // TODO: should also be able to save the trained model to a file and load again for test set

}
