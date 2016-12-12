package org.deep.learning.neuralNetwork.network.supervised

import org.scalatest.{FlatSpec, Matchers, OptionValues}

class MultiLayerPerceptronSpec extends FlatSpec with Matchers with OptionValues {

  val inputValues: List[BigDecimal] = List(1, 1)

  behavior of "MLP"

  it should "create MLP with 3 layers, each layer consisting of 2 neurons" in {

    val mlp = MultiLayerPerceptron(3, 2, Some(inputValues))
    val layers = mlp.layers
    val output = mlp.output

    output should be (List(4, 4))
  }

  it should "create MLP with 4 layers, each layer consisting of 2 neurons" ignore {

    val mlp = MultiLayerPerceptron(4, 2, Some(inputValues))
    val layers = mlp.layers
    val output = mlp.output

    output should be (List(8, 8))
  }

}
