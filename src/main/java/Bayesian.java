/**
 * Created by kellykrawczyk on 11/11/16.
 */
public class Bayesian {

    private List<List<Double>> Data;
    private List<List<String>> Date;
    private List<List<String>> BAYAction;

    private double BAYBalance;
    private int[] BAYNumStock;

    public Bayesian() {

        Data = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            Data.add(new ArrayList());
        }
        Date = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            Date.add(new ArrayList());
        }
        BAYAction = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            BAYAction.add(new ArrayList());
        }

        BAYBalance = 1000000;

        BAYNumStock = new int[10];
    }

    public void runBayesian() {

        double balanceTemp;

        for (int i = 0; i < DataReader.SYMBOLS.length; ++i) {

            loadData(i);

        }

        for (int j = BAYAction.get(0).size() - 1; j >= 0; j--) {

            String date = Date.get(0).get(j);

            Double Total = BAYBalance;

            for (int i = 0; i < DataReader.SYMBOLS.length; ++i) {
                Total += BAYNumStock[i] * Data.get(i).get(j);
            }

            try {

                Connection connection;

                connection = DriverManager.getConnection(DatabaseManager.URL + DatabaseManager.DATABASE_NAME, DatabaseManager.USER_NAME, DatabaseManager.PASSWORD);

                Statement statement = connection.createStatement();

                statement.executeUpdate("INSERT INTO AIBAY VALUES ('" + date + "', " + Math.round(Total * 100.0) / 100.0 + ")");

                connection.close();

            } catch (Exception e) {
                System.out.println("database operation error 1.");
            }

            balanceTemp = BAYBalance;
            for (int i = 0; i < DataReader.SYMBOLS.length; ++i) {

                if (BAYAction.get(i).get(j).equals("BUY")) {

                    Double price = Data.get(i).get(j);

                    int numStock = (int) (balanceTemp * 0.2 * 0.1 / price);

                    BAYBalance -= numStock * price;
                    BAYNumStock[i] += numStock;

                }

                if (BAYAction.get(i).get(j).equals("SELL")) {

                    Double price = Data.get(i).get(j);

                    BAYBalance += (BAYNumStock[i] / 50) * price;
                    BAYNumStock[i] -= BAYNumStock[i] / 50;

                }
            }
        }
    }

    private void loadData(int CompanyIndex) {

        try {

            Connection connection;

            connection = DriverManager.getConnection(DatabaseManager.URL + DatabaseManager.DATABASE_NAME, DatabaseManager.USER_NAME, DatabaseManager.PASSWORD);

            Statement statement = connection.createStatement();


            // load action
            res = statement.executeQuery("SELECT * FROM SPredictionBayesian WHERE Symbol = '" + DataReader.SYMBOLS[CompanyIndex] + "' order by Date desc limit 200");

            while (res.next()) {
                BAYAction.get(CompanyIndex).add(res.getString("Action"));
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("database operation error 1.");
        }

    }
}
