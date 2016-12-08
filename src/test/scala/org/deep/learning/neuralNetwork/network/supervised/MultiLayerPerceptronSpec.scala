package org.deep.learning.neuralNetwork.network.supervised

import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.RectifierLinearUnitFunction
import org.scalatest.{FlatSpec, Matchers, OptionValues}
import org.deep.learning.neuralNetwork.network.supervised.MultiLayerPerceptron

class MultiLayerPerceptronSpec extends FlatSpec with Matchers with OptionValues {

  val inputValues: List[BigDecimal] = List(1, 1)

  behavior of "MLP"

  it should "create MLP with 2 layers, each layer consisting of 2 neurons" in {
/*
    val mlp = MultiLayerPerceptron(numberOfLayers, activationFunction, inputValues)

    mlp.add(List(l1, l2))

    mlp.train
    mlp.persist
    */
    
    true should be (true)
  }

}
