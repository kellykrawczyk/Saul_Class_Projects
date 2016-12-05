package scala

import Reader.DisneyReader

import scala.DisneyDataModel._
import scala.collection.JavaConversions._


object DisneyApp extends App{

  val reader = new DisneyReader

  val Data = reader.disneyData
  val trainSplit = math.ceil(Data.size()*0.7).toInt
  val trainData = Data.subList(0, trainSplit)
  val testData = Data.subList(trainSplit, Data.size() - 1)




  DisneyDataModel.disney populate(trainData)
  print(EPS(trainData.get(3)))


  DisneyClassifier.firstClassifier.learn(30)
  DisneyClassifier.firstClassifier.test(testData)
  println(DisneyClassifier.firstClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.secondClassifier.learn(30)
  DisneyClassifier.secondClassifier.test(testData)
  println(DisneyClassifier.secondClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.SparseNetworkClassifier.learn(30)
  DisneyClassifier.SparseNetworkClassifier.test(testData)
  println(DisneyClassifier.SparseNetworkClassifier.classifier.discreteValue(testData.get(100)))

  //DisneyClassifier.WekaClassifier.learn(30)
  //DisneyClassifier.WekaClassifier.test(testData)
  //println(DisneyClassifier.WekaClassifier.classifier.discreteValue(testData.get(100)))

  //DisneyClassifier.BayesNetworkClassifier.learn(30)
  //DisneyClassifier.BayesNetworkClassifier.test(testData)
  //println(DisneyClassifier.BayesNetworkClassifier.classifier.discreteValue(testData.get(100)))

  val overestimate = testData.filter(x => prediction_value(x) == 1.0)
  val underestimate = overestimate.filter(x => prediction_value(x) != 1.0)

  var i = 0;

  for (i <- 0 to (underestimate.size - 1)){
    println(underestimate.get(i).date)
  }

  println()

  val predicted_overestimate = testData.filter(x => prediction_value(x) == 1.0)
  val incorrect_overestimate = predicted_overestimate.filter(x => prediction_value(x) != 1.0)

  for (i <- 0 to (incorrect_overestimate.size - 1)){
    println(incorrect_overestimate.get(i).date)
  }


}
