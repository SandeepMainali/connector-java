import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/connector";
        Connection conn = DriverManager.getConnection(url, "root", "");
        System.out.println("Connection Successfully");

        //Fetch data from the database;
//        Statement statement = conn.createStatement();
//         ResultSet resultSet = statement.executeQuery("SELECT * from same");
//         ResultSet resultSet1 = statement.executeQuery("INSERT into same(Id,Name,Address)values(2,abc,xyz)");
//         System.out.println(resultSet);



        //prepared statement
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from same WHERE Id=? AND Name=?");
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"Sandeep");
//        preparedStatement.setString(3,"Abc");
        ResultSet resultSet = preparedStatement.executeQuery();


         while (resultSet.next()){
             System.out.print(resultSet.getInt("Id") +".");
             System.out.print(resultSet.getString("name"));
             System.out.print(" ");
             System.out.print(resultSet.getString("Address"));
             System.out.println("\n");
         }


    }
}
