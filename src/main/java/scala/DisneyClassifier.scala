package scala

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
    override def feature = using(op_expenseFeature, EBITFeature, op_incFeature)

  }

 object secondClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SupportVectorMachine()
    override def feature = using(total_debtFeature, shares_outstandingFeature, change_in_NCWCFeature, cap_expFeature, int_expenseFeature, EBITFeature, op_incFeature)

  }

  object SparseNetworkClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SparseNetworkLearner()
    override def feature = using(ev_year_cash_flowFeature, EBITDAFeature, r_squaredFeature, op_expenseFeature)
  }

  object RandomForestClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override def feature = using(rev_valFeature, NCWCFeature, tot_liabFeature, mkt_capFeature, net_incomeFeature, volatilityFeature, betaFeature)
    override lazy val classifier = new SaulWekaWrapper(new RandomForest())
  }

  object RandomForestClassifier2 extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SaulWekaWrapper(new RandomForest())
    override def feature = using(total_debtFeature, shares_outstandingFeature, change_in_NCWCFeature, cap_expFeature, int_expenseFeature, EBITFeature, op_incFeature)
  }


  object MultiLayerPerceptronClassifier extends Learnable[String](disney) {
    def label = trustLabel
    override lazy val classifier = new SaulWekaWrapper(new MultilayerPerceptron())
    override def feature = using(volatilityFeature, betaFeature, net_incomeFeature, total_debtFeature, mkt_capFeature, change_in_NCWCFeature)
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
