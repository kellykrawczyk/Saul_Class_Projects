package scala

import Reader.DisneyStock
import edu.illinois.cs.cogcomp.lbjava.learn.{SparseNetworkLearner, SupportVectorMachine}
import weka.classifiers.bayes.{BayesNet, NaiveBayes}
import weka.classifiers.functions.MultilayerPerceptron
import weka.classifiers.trees.RandomForest


object DisneyClassifier {

  import DisneyDataModel._
  import edu.illinois.cs.cogcomp.saul.classifier.Learnable
  import edu.illinois.cs.cogcomp.saul.learn.SaulWekaWrapper


  object firstClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SupportVectorMachine()

    //override def feature = using(beta, EBITDA, EBIT, total_debt)
    override def feature = using(op_expenseFeature, EBITFeature, op_incFeature)

  }

 object secondClassifier extends Learnable[String](disney) {
    def label = trustLabel
    //override def feature = using(betaFeature, EBITDAFeature, EBITFeature, total_debtFeature)
    override def feature = using(total_debtFeature, shares_outstandingFeature, change_in_NCWCFeature, cap_expFeature, int_expenseFeature, EBITFeature, op_incFeature)
    override lazy val classifier = new SupportVectorMachine()

  }

  object SparseNetworkClassifier extends Learnable[String](disney) {
    def label = trustLabel
    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    override def feature = using(ev_year_cash_flowFeature, EBITDAFeature, r_squaredFeature, op_expenseFeature)
    override lazy val classifier = new SparseNetworkLearner()
  }

  object RandomForestClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override def feature = using(rev_valFeature, NCWCFeature, tot_liabFeature, mkt_capFeature, net_incomeFeature, volatilityFeature, betaFeature)

    override lazy val classifier = new SaulWekaWrapper(new RandomForest())

    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    //override def feature = using(shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc, ev_year_cash_flow, EBITDA)
  }

  object RandomForestClassifier2 extends Learnable[String](disney) {
    def label = trustLabel
    //override def feature = using(rev_val, NCWC, tot_liab, mkt_cap, net_income, volatility, beta)

    override lazy val classifier = new SaulWekaWrapper(new RandomForest())

    override def feature = using(total_debtFeature, shares_outstandingFeature, change_in_NCWCFeature, cap_expFeature, int_expenseFeature, EBITFeature, op_incFeature)
    //override def feature = using(shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc, ev_year_cash_flow, EBITDA)
  }


  object MultiLayerPerceptronClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SaulWekaWrapper(new MultilayerPerceptron())
    override def feature = using(volatilityFeature, betaFeature, net_incomeFeature, total_debtFeature, mkt_capFeature, change_in_NCWCFeature)
    //override def feature = using(cap_exp, tot_liab, int_expense, NCWV, EBIT, rev_val, op_inc, op_expense)
    //override def feature = using(EBITDA, ev_year_cash_flow, r_squared, op_inc, op_expense, EBIT)
  }

  object WekaClassifier extends Learnable(disney) {
    def label = trustLabel
    override lazy val classifier = new SaulWekaWrapper(new NaiveBayes())
    override def feature = using(rev_valFeature, NCWCFeature, tot_liabFeature, mkt_capFeature, net_incomeFeature, volatilityFeature, betaFeature)
  }

  object BayesNetworkClassifier extends Learnable(disney) {
    def label = trustLabel
    override lazy val classifier = new SaulWekaWrapper(new BayesNet())
    override def feature = using(betaFeature, total_debtFeature, shares_outstandingFeature, change_in_NCWCFeature, cap_expFeature, int_expenseFeature, EBITFeature)
  }

}
