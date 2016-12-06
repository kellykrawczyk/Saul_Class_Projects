package scala


import edu.illinois.cs.cogcomp.saul.datamodel.DataModel


object DisneyDataModel extends DataModel{

  val disney = node[String]

  val betaFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(1).toDouble
  }

  val total_debtFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(2).toDouble
  }

  val shares_outstandingFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(3).toDouble
  }

  val change_in_NCWCFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(4).toDouble
  }

  val cap_expFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(5).toDouble
  }

  val int_expenseFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(6).toDouble
  }

  val EBITFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(7).toDouble
  }

  val op_incFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(8).toDouble
  }

  val ev_year_cash_flowFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(9).toDouble
  }

  val EBITDAFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(10).toDouble
  }

  val r_squaredFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(11).toDouble
  }

  val op_expenseFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(12).toDouble
  }

  val rev_valFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(13).toDouble
  }

  val NCWCFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(14).toDouble
  }

  val tot_liabFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(15).toDouble
  }

  val mkt_capFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(16).toDouble
  }

  val net_incomeFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(17).toDouble
  }

  val volatilityFeature = property(disney){
    x: String =>
      val tokens = x.split(",")
      tokens(18).toDouble
  }

  val estimateLabel = property(disney) {
    x: String =>
      val tokens = x.split(",")
      if (tokens(19).equals(tokens(20)))
        "Correct"
      else
        "Incorrect"
  }

  val trustLabel = property(disney) {
    x: String =>
      val tokens = x.split(",")
      if (tokens(19).equals(tokens(20)))
        "Trust"
      else if (Math.abs(tokens(19).toDouble - tokens(20).toDouble) <= 0.5)
        "Trust"
      else
        "Don't trust"
  }






  }

  /*val TrustLabel = property(disney){
    x: Int =>
      if (x.estimate.equals(true))


  }


  val prediction = property(disney){
    x: DisneyStock => firstClassifier.classifier.discreteValue(x)
  }

}*/
