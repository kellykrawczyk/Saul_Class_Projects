package scala

import Reader.DisneyStock
import edu.illinois.cs.cogcomp.lbjava.learn.{SparseNetworkLearner, SupportVectorMachine}
import edu.illinois.cs.cogcomp.saul.classifier.Learnable
import edu.illinois.cs.cogcomp.saul.learn.SaulWekaWrapper
import weka.classifiers.bayes.{BayesNet, NaiveBayes}
import weka.classifiers.functions.MultilayerPerceptron
import weka.classifiers.trees.RandomForest

object DisneyClassifier {

  import DisneyDataModel._

  object firstClassifier extends Learnable[DisneyStock](disney) {
    def label = estimate
    override def feature = using(beta, EBITDA, EBIT, total_debt)
    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    override lazy val classifier = new SupportVectorMachine()

  }

  object SparseNetworkClassifier extends Learnable[DisneyStock](disney) {
    def label = estimate
    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    override def feature = using(ev_year_cash_flow, EBITDA, r_squared, op_expense)
    override lazy val classifier = new SparseNetworkLearner()
  }

  object RandomForestClassifier extends Learnable[DisneyStock](disney) {
    def label = estimate_value
    override lazy val classifier = new SaulWekaWrapper(new RandomForest())
    override def feature = using(rev_val, NCWC, tot_liab, mkt_cap, net_income, volatility, beta)
    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    //override def feature = using(shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc, ev_year_cash_flow, EBITDA)
  }

  object RandomForestClassifier2 extends Learnable[DisneyStock](disney) {
    def label = estimate_value
    override lazy val classifier = new SaulWekaWrapper(new RandomForest())
    //override def feature = using(rev_val, NCWC, tot_liab, mkt_cap, net_income, volatility, beta)
    override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    //override def feature = using(shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc, ev_year_cash_flow, EBITDA)
  }


  object MultiLayerPerceptronClassifier extends Learnable[DisneyStock](disney) {
    def label = estimate
    override lazy val classifier = new SaulWekaWrapper(new MultilayerPerceptron())
    override def feature = using(volatility, beta, net_income, total_debt, mkt_cap, change_in_NCWC)
    //override def feature = using(cap_exp, tot_liab, int_expense, NCWV, EBIT, rev_val, op_inc, op_expense)
    //override def feature = using(EBITDA, ev_year_cash_flow, r_squared, op_inc, op_expense, EBIT)
  }

  object WekaClassifier extends Learnable(disney) {
    def label = estimate
    override lazy val classifier = new SaulWekaWrapper(new NaiveBayes())
    override def feature = using(rev_val, NCWC, tot_liab, mkt_cap, net_income, volatility, beta)
  }

  object BayesNetworkClassifier extends Learnable(disney) {
    def label = estimate
    override lazy val classifier = new SaulWekaWrapper(new BayesNet())
    override def feature = using(beta, total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT)
  }

}
