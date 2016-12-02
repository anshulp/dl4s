package org.deep.learning.classifiers

import org.deep.learning.util.Utils._

object LogisticRegression {
  def apply(
    dataRows: List[List[Double]],
    seedWeights: List[Double],
    learningRate: Double,
    maxIterations: Int): LogisticRegression = {

    assert(dataRows != null, "data should not be null")
    assert(seedWeights != null, "weights should not be null")

    val ZERO_LOGIT: Double = math.pow(math.E, -10)

    new LogisticRegression(
      labels = dataRows.map(row => row(0)),
      features = dataRows.map(row => List(1.0) ++ row.slice(1, row.length)), // pre-pend each feature with 1
      seedWeights = seedWeights,
      learningRate = learningRate,
      maxIterations = maxIterations)
  }
}

// Refer section 2 - http://cs229.stanford.edu/notes/cs229-notes1.pdf
class LogisticRegression(
  labels: List[Double],
  features: List[List[Double]],
  seedWeights: List[Double],
  learningRate: Double,
  maxIterations: Int) {

  //TODO: Add tolerance (predictedLabel - actualLabel) > tolerance, break the training loop

  private val learnedWeights: List[Double] = {
    // learn till maxIteration
      // for each feature/label combination
    (0 to maxIterations-1).foldLeft(seedWeights) {(weights, iter) => {
      (0 to features.size - 1).foldLeft(seedWeights) { (weights, featureIndex) => {

        val predictedLabel: Double = sigmoidFor(x = features(featureIndex), weights = weights)
        val actualLabel: Double = labels(featureIndex)

        val diff = (actualLabel - predictedLabel)

        weights.map(w => multiplyVectors(weights, features(featureIndex)).sum * diff)
      }
      }
    }
    }
  }

  private def sigmoidFor(x: List[Double], weights: List[Double]): Double = {

    val actualLogit: Double = {
      val multipliedValue = multiplyVectors(weights, x).sum
      if (multipliedValue != 0) -1 * multipliedValue else 0
    }

    val logit =
      if (actualLogit == 0) 0.00000000000000000000001
      else if (actualLogit == 1) 0.99999999999999999999999
      else actualLogit

    1 / (1 + math.pow(math.E, logit))
  }

  def predict(x: List[Double]): Int = {

    // prepend Ist feature (1) to the list
    val features = List(1.0) ++ x

    val probability = sigmoidFor(features, learnedWeights)
    if (probability >= 0.5)
      1
    else
      0
  }

}
