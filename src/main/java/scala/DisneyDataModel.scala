package scala


import Reader.DisneyStock
import edu.illinois.cs.cogcomp.saul.datamodel.DataModel

import DisneyClassifier._

object DisneyDataModel extends DataModel{

  val disney = node[DisneyStock]

  val date = property(disney){
    x: DisneyStock =>
      val d = x.date
      d
  }

  val beta = property(disney){
    x: DisneyStock =>
      val b = x.beta.toDouble
      b
  }

  val total_debt = property(disney){
    x: DisneyStock =>
      val td = x.total_debt.toDouble
      td
  }
  val shares_outstanding = property(disney){
    x: DisneyStock =>
      val so = x.shares_outstanding.toDouble
      so
  }

  val change_in_NCWC = property(disney){
    x: DisneyStock =>
      val c_ncwc = x.change_in_NCWC.toDouble
      c_ncwc
  }

  val cap_exp = property(disney){
    x: DisneyStock =>
      val ce = x.cap_exp.toDouble
      ce
  }

  val int_expense = property(disney){
    x: DisneyStock =>
      val ie = x.int_expense.toDouble
      ie
  }

  val EBIT = property(disney){
    x: DisneyStock =>
      val ebit = x.EBIT.toDouble
      ebit
  }

  val op_inc = property(disney){
    x: DisneyStock =>
      val oi = x.op_inc.toDouble
      oi
  }

  val ev_year_cash_flow = property(disney){
    x: DisneyStock =>
      val evcf = x.ev_year_cash_flow.toDouble
      evcf
  }

  val EBITDA = property(disney){
    x: DisneyStock =>
      val ebitda = x.EBITDA.toDouble
      ebitda
  }

  val r_squared = property(disney){
    x: DisneyStock =>
      val r = x.r_squared.toDouble
      r
  }

  val op_expense = property(disney){
    x: DisneyStock =>
      val oe = x.op_expense.toDouble
      oe
  }

  val rev_val = property(disney){
    x: DisneyStock =>
      val rv = x.rev_val.toDouble
      rv
  }

  val NCWC = property(disney){
    x: DisneyStock =>
      val ncwv = x.NCWV.toDouble
      ncwv
  }

  val tot_liab = property(disney){
    x: DisneyStock =>
      val tl = x.tot_liab.toDouble
      tl
  }

  val mkt_cap = property(disney){
    x: DisneyStock =>
      val mc = x.mkt_cap.toDouble
      mc
  }

  val net_income = property(disney){
    x: DisneyStock =>
      val ni = x.net_income.toDouble
      ni
  }

  val volatility = property(disney){
    x: DisneyStock =>
      val v = x.volatility.toDouble
      v
  }

  val EPS = property(disney){
    x: DisneyStock =>
      val eps = x.EPS.toDouble
      eps
  }

  val BEST_EPS = property(disney){
    x: DisneyStock =>
      val best_eps = x.BEST_EPS.toDouble
      best_eps
  }

  val prediction = property(disney){
    x: DisneyStock => x.prediction
  }

  val prediction_value = property(disney){
    x: DisneyStock => x.prediction_value.toDouble
  }

  val estimate = property(disney){
    x: DisneyStock => secondClassifier.classifier.discreteValue(x)
  }

}
