package org.deep.learning.neuralNetwork.network.supervised

import breeze.linalg.DenseMatrix
import org.scalatest.{FlatSpec, Matchers, OptionValues}

class MultiLayerPerceptronSpec extends FlatSpec with Matchers with OptionValues {

  val inputFeatureValues: List[BigDecimal] = List(1, 1)
  val matrix = DenseMatrix((1.0,1.0), (1.0,1.0))
  val weightMatrix = Map(
    1 -> matrix,
    2 -> matrix
  )

  behavior of "MLP"

  it should "create MLP with 3 layers, each layer consisting of 2 neurons" in {

    val mlp = MultiLayerPerceptron(3, 2, weightMatrix, Some(inputFeatureValues))
    val layers = mlp.layers
    val output = mlp.output

    output should be (List(4, 4))
  }

}
