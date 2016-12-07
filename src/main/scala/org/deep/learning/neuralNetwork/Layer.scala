package org.deep.learning.neuralNetwork

object Layer {

  def apply(numberOfNeurons: Int): Layer = {

    assert(numberOfNeurons < 1, "Number of neurons in the layer cannot be less than one.")

    new Layer(numberOfNeurons = numberOfNeurons)
  }
}

class Layer(
  numberOfNeurons: Int) {

  // Build a layer?
  // add a bias neuron



}
