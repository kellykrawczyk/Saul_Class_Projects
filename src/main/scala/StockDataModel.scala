/**
  * Created by kellykrawczyk on 11/22/16.
  */

import java_classes.stockData

import StockClassifier.firstCompanyClassifier
import edu.illinois.cs.cogcomp.saul.datamodel.DataModel

object StockDataModel extends DataModel{
  val comp = node[stockData]

  val name = property(comp){
    x: stockData =>
      val a = x.name
      a
  }

  val MA_50 = property(comp){
    x: stockData =>
      val b = x.MA_50.toDouble
      b
  }

  val MA_200 = property(comp){
    x: stockData =>
      val c = x.MA_200.toDouble
      c
  }

  val PER = property(comp){
    x: stockData =>
      val d = x.PER.toDouble
      d
  }

  val PBV = property(comp){
    x: stockData =>
      val e = x.PBV.toDouble
      e
  }

  val EBITDA = property(comp){
    x: stockData =>
      val f = x.EBITDA.toDouble
      f
  }

  val DECISION = property(comp){
    x: stockData =>
      val g = x.DECISION.toDouble
      g
  }

  val TICKER = property(comp){
    x: stockData =>
      val h = x.TICKER
      h
  }




  val prediction = property(comp){
    x: stockData => firstCompanyClassifier.classifier.realValue(x)
  }


}
