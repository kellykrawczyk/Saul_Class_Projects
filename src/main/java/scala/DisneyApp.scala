package scala

import Reader._

//import scala.DisneyDataModel._

import scala.DisneyClassifier._
import Reader.DisneyReader
import scala.collection.JavaConversions._

//import edu.illinois.cs.cogcomp.saul.util.Logging

object DisneyApp extends App {

  //val reader = new DisneyReader

 // val Data = reader.disneyData
 // val trainSplit = math.ceil(Data.size()*0.7).toInt
  //val trainData = Data.subList(0, trainSplit)
  //val testData = Data.subList(trainSplit, Data.size() - 1)

  val trainData = new DisneyReader("data/stocks/stocks.train").disneyData
  val testData = new DisneyReader("data/stocks/stocks.test").disneyData


  DisneyDataModel.disney.populate(trainData)
  DisneyDataModel.disney populate(testData, false)


  //DisneyDataModel.disney.populate(trainData)
  //DisneyDataModel.disney populate(testData)
  //print(BEST_EPS(trainData.get(3)))
  //ClassifierUtils.TestClassifiers(DisneyClassifier.firstClassifier)

  firstClassifier.learn(30)
  firstClassifier.test()

  secondClassifier.learn(30)
  secondClassifier.test()

  //println(DisneyClassifier.firstClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.SparseNetworkClassifier.learn(30)
  DisneyClassifier.SparseNetworkClassifier.test()

  //println(DisneyClassifier.SparseNetworkClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.RandomForestClassifier.learn(30)
  DisneyClassifier.RandomForestClassifier.test()
 // println(DisneyClassifier.RandomForestClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.RandomForestClassifier2.learn(20)
  DisneyClassifier.RandomForestClassifier2.test()

  DisneyClassifier.MultiLayerPerceptronClassifier.learn(30)
  DisneyClassifier.MultiLayerPerceptronClassifier.test()
  //println(DisneyClassifier.MultiLayerPerceptronClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.WekaClassifier.learn(30)
  DisneyClassifier.WekaClassifier.test(testData)
  //println(DisneyClassifier.WekaClassifier.classifier.discreteValue(testData.get(100)))

  DisneyClassifier.BayesNetworkClassifier.learn(30)
  DisneyClassifier.BayesNetworkClassifier.test(testData)
  //println(DisneyClassifier.BayesNetworkClassifier.classifier.discreteValue(testData.get(100)))*/

  /*val trust = testData.filter(x => estimate(x) == true)
  val dont_trust = trust.filter(x => trust(x) != 1)

  var i = 0

  for (i <- 0 until (trust.size - 1)){
    println(trust.get(i).date + ":" + prediction(trust.get(i)))
  }

  println()

  val correct_trust = testData.filter(x => trust(x) == 1)
  val incorrect_trust = correct_trust.filter(x => estimate(x) != true)

  for (i <- 0 until (incorrect_trust.size - 1)){
    println(incorrect_trust.get(i).date + ":" + estimate(incorrect_trust.get(i)))
  }
*/

}
