package org.deep.learning.neuralNetwork.network

trait NeuralNetwork {

  //https://www.toptal.com/machine-learning/an-introduction-to-deep-learning-from-perceptrons-to-deep-networks

  val output: List[BigDecimal]

  // TODO: should also be able to save the trained model to a file and load again for test set

}
