package org.deep.learning.neuralNetwork.network.supervised

import org.deep.learning.neuralNetwork.Layer
import org.deep.learning.neuralNetwork.activation.RectifierLinearUnitFunction
import org.scalatest.{FlatSpec, Matchers, OptionValues}
import org.deep.learning.neuralNetwork.network.supervised.MultiLayerPerceptron

class MultiLayerPerceptronSpec extends FlatSpec with Matchers with OptionValues {

  val inputValues: List[BigDecimal] = List(1, 1)

  behavior of "MLP"

  it should "create MLP with 2 layers, each layer consisting of 2 neurons" in {

    val mlp = MultiLayerPerceptron
    val l1 = Layer(2, inputValues, RectifierLinearUnitFunction())
    val l2 = Layer(2)
    mlp.add(l1)
    mlp.add(l2)

    mlp.train
    mlp.persist
  }

}
