import java.sql.*;

public class CallProcedureExample {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/chinook";
        String user = "root";
        String password = "23051985";

        try {
            Connection connection = DriverManager.getConnection(URL, user, password);

            CallableStatement callProcedure = connection.prepareCall("{call getCustomerById(?)}");
            callProcedure.setInt(1, 5);

            ResultSet resultSet = callProcedure.executeQuery();

            while (resultSet.next()) {
                System.out.println("FirstName: " + resultSet.getString("FirstName"));
            }

            resultSet.close();
            callProcedure.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
