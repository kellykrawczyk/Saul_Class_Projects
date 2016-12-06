package scala

import Reader._

import scala.DisneyDataModel._
import scala.collection.JavaConversions._


object DisneyApp extends App{

  val reader = new DisneyReader

  val Data = reader.disneyData
  val trainSplit = math.ceil(Data.size()*0.7).toInt
  val trainData = Data.subList(0, trainSplit)
  val testData = Data.subList(trainSplit, Data.size() - 1)




  DisneyDataModel.disney populate(trainData)
  //print(BEST_EPS(trainData.get(3)))
  //ClassifierUtils.TestClassifiers(DisneyClassifier.firstClassifier)

  //DisneyClassifier.firstClassifier.learn(3)
  //DisneyClassifier.firstClassifier.test(testData)
  //println(DisneyClassifier.firstClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.SparseNetworkClassifier.learn(3)
  DisneyClassifier.SparseNetworkClassifier.test(testData)
  //println(DisneyClassifier.SparseNetworkClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.RandomForestClassifier.learn(10)
  DisneyClassifier.RandomForestClassifier.test(testData)
 // println(DisneyClassifier.RandomForestClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.RandomForestClassifier2.learn(2)
  DisneyClassifier.RandomForestClassifier2.test(testData)

  DisneyClassifier.MultiLayerPerceptronClassifier.learn(30)
  DisneyClassifier.MultiLayerPerceptronClassifier.test(testData)
  //println(DisneyClassifier.MultiLayerPerceptronClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.WekaClassifier.learn(30)
  DisneyClassifier.WekaClassifier.test(testData)
  //println(DisneyClassifier.WekaClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.BayesNetworkClassifier.learn(30)
  DisneyClassifier.BayesNetworkClassifier.test(testData)
  //println(DisneyClassifier.BayesNetworkClassifier.classifier.discreteValue(testData.get(100)))

  val overestimate = testData.filter(x => estimate(x) == "Overestimate")
  val not_overestimate = overestimate.filter(x => prediction(x) != "Overestimate")

  var i = 0

  for (i <- 0 to (not_overestimate.size - 1)){
    println(not_overestimate.get(i).date + ":" + prediction(not_overestimate.get(i)))
  }

  println()

  val predicted_overestimate = testData.filter(x => prediction(x) == "Overestimate")
  val incorrect_overestimate = predicted_overestimate.filter(x => estimate(x) != "Overestimate")

  for (i <- 0 to (incorrect_overestimate.size - 1)){
    println(incorrect_overestimate.get(i).date + ":" + estimate(incorrect_overestimate.get(i)))
  }


}
