package scala

import scala.DisneyClassifier._
import Reader.DisneyReader
import scala.collection.JavaConversions._


object DisneyApp extends App {

  val trainData = new DisneyReader("data/stocks/stocks.train").disneyData
  val testData = new DisneyReader("data/stocks/stocks.test").disneyData

  DisneyDataModel.disney.populate(trainData)
  DisneyDataModel.disney populate(testData, false)

  firstClassifier.learn(30)
  firstClassifier.test()

  secondClassifier.learn(30)
  secondClassifier.test()

  DisneyClassifier.SparseNetworkClassifier.learn(30)
  DisneyClassifier.SparseNetworkClassifier.test()

  DisneyClassifier.RandomForestClassifier.learn(30)
  DisneyClassifier.RandomForestClassifier.test()

  DisneyClassifier.RandomForestClassifier2.learn(20)
  DisneyClassifier.RandomForestClassifier2.test()

  DisneyClassifier.MultiLayerPerceptronClassifier.learn(30)
  DisneyClassifier.MultiLayerPerceptronClassifier.test()

  DisneyClassifier.WekaClassifier.learn(30)
  DisneyClassifier.WekaClassifier.test(testData)

  DisneyClassifier.BayesNetworkClassifier.learn(30)
  DisneyClassifier.BayesNetworkClassifier.test(testData)

}
