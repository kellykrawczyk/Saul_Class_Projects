/**
  * Created by kellykrawczyk on 11/22/16.
  */

import java_classes.stockData

import edu.illinois.cs.cogcomp.lbjava.learn.SupportVectorMachine
import edu.illinois.cs.cogcomp.saul.classifier.Learnable


  object StockClassifier {

    import StockDataModel._

    object firstCompanyClassifier extends Learnable[stockData](comp) {
      def label = TICKER
      override def feature = using(MA_50, MA_200, PER, PBV)
      override lazy val classifier = new SupportVectorMachine()

    }

    object StockClassifier2 extends Learnable[stockData](comp) {
      //def label = TICKER
      def label = DECISION
      //override def feature = using(MA_200, MA_50, PER, PBV)
      override def feature = using(MA_200, MA_50, EBITDA, PER, PBV)
      override lazy val classifier = new SupportVectorMachine()

    }

    /*object StockClassifierNB extends Learnable(comp) {
      def label = TICKER
      override lazy val classifier = new NaiveBayes()
      override def feature = using(MA_50, MA_200, PBV, PER, EBITDA)
    }

    object StockClassifierBayesNetwork extends Learnable(comp) {
      //def label = TICKER
      def label = DECISION
      override lazy val classifier = new BayesNet()
      override def feature = using(PER, EBITDA)
      //override def feature = using(PBV, PER, EBITDA)
    }*/






}
