/**
  * Created by kellykrawczyk on 11/22/16.
  */

import java_classes.DataReader

import StockDataModel._
import edu.illinois.cs.cogcomp.saul.classifier.ClassifierUtils

import scala.collection.JavaConversions._

object StockApp extends App{

  val reader = new DataReader()

  val allData = reader.symbolData

  val trainSplit = math.ceil(allData.size()*0.7).toInt

  val trainData = allData.subList(0, trainSplit)
  val testData = allData.subList(trainSplit, allData.size() - 1)


  StockDataModel.comp populate trainData
  print(MA_50(instance = trainData.get(3)))
  ClassifierUtils.TestClassifiers(StockClassifier.firstCompanyClassifier)


  StockClassifier.firstCompanyClassifier.learn(3)
  StockClassifier.firstCompanyClassifier.test(testData)
  println(StockClassifier.firstCompanyClassifier.classifier.discreteValue(testData.get(86)))




  StockClassifier.StockClassifier2.learn(3)
  StockClassifier.StockClassifier2.test(testData)

  println(StockClassifier.StockClassifier2.classifier.discreteValue(testData.get(86)))



 /* StockClassifier.StockClassifierNB.learn(3)
  StockClassifier.StockClassifierNB.test(testData)



  StockClassifier.StockClassifierBayesNetwork.learn(10)
  StockClassifier.StockClassifierBayesNetwork.test(testData)



  StockClassifier.StockClassifier2.learn(10)
  StockClassifier.StockClassifierBayesNetwork.test(testData)*/




  val buy_stock = testData.filter(x => DECISION(x) > 0)
  val sell_stock = buy_stock.filter(x => prediction(x) <= 0)
  var i = 0

  for( i <- sell_stock.indices){
    println(sell_stock.get(i).name)
  }


}