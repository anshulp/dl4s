package org.deep.learning.neuralNetwork

object Link {

  def apply(weight: BigDecimal): Link = new Link(weight = weight)

}

// Links Neurons between layers
class Link(
  weight: BigDecimal) {

}