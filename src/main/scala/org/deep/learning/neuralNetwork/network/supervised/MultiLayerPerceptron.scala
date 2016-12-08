package org.deep.learning.neuralNetwork.network.supervised

import org.deep.learning.neuralNetwork.network.NeuralNetwork
import org.deep.learning.neuralNetwork.Layer

object MultiLayerPerceptron {

  def apply: MultiLayerPerceptron = new MultiLayerPerceptron()
}

class MultiLayerPerceptron extends NeuralNetwork {

  val output = List.empty

  val layers: List[Layer] = List.empty
}
