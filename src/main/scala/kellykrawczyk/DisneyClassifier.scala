package kellykrawczyk

/**
  * Created by kellykrawczyk on 12/5/16.
  */
import edu.illinois.cs.cogcomp.lbjava.learn.SupportVectorMachine
import edu.illinois.cs.cogcomp.lbjava.learn.SparseNetworkLearner
import edu.illinois.cs.cogcomp.saul.classifier.Learnable
import edu.illinois.cs.cogcomp.lbjava.learn.StochasticGradientDescent
import weka.classifiers.bayes.NaiveBayes
import weka.classifiers.bayes.BayesNet
import weka.classifiers.trees.RandomForest
import weka.classifiers.functions.MultilayerPerceptron
import edu.illinois.cs.cogcomp.saul.learn.SaulWekaWrapper
import edu.illinois.cs.cogcomp.saul

object DisneyClassifier {

  import DisneyDataModel._

  object firstClassifier extends Learnable[DisneyStock](disney) {
    def label = prediction
    override def feature = using(beta, EBITDA, EBIT, total_debt)
    override lazy val classifier = new SupportVectorMachine()

  }

  object secondClassifier extends Learnable[DisneyStock](disney) {
    def label = prediction
    override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    override lazy val classifier = new SupportVectorMachine()

  }

  object SparseNetworkClassifier extends Learnable[DisneyStock](disney) {
    def label = prediction
    //override def feature = using(total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT, op_inc)
    override def feature = using(ev_year_cash_flow, EBITDA, r_squared, op_expense)
    override lazy val classifier = new SparseNetworkLearner()
  }

  object WekaClassifier extends Learnable(disney) {
    def label = prediction
    override lazy val classifier = new SaulWekaWrapper(new NaiveBayes())
    override def feature = using(rev_val, NCWV, tot_liab, mkt_cap, net_income, volatility, beta)
  }

  object BayesNetworkClassifier extends Learnable(disney) {
    def label = prediction
    override lazy val classifier = new SaulWekaWrapper(new BayesNet())
    override def feature = using(beta, total_debt, shares_outstanding, change_in_NCWC, cap_exp, int_expense, EBIT)
  }





}
