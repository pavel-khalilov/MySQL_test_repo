import java.sql.*;

public class SelectQueryExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/chinook";
        String user = "root";
        String password = "23051985";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            String sqlQuery = "select * from customer where customerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 5);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("CustomerId");
                String firstName = resultSet.getString("FirstName");
                System.out.println("User: " + customerId + ", name: " + firstName);
                System.out.println("--------------------------------------");
                System.out.println("Last Name: " + resultSet.getString("LastName"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}