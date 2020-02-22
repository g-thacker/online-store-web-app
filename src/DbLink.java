import java.sql.*;
import java.util.ArrayList;

public class DbLink {
    public static ArrayList<Product> getProducts() {
        Statement statement = null; // ??
        ArrayList<Product> productArrayList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Product;";
        Connection connection;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Store", "root", "mysql");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Product thisProduct = new Product();
                thisProduct.setProdId(resultSet.getString("ProdID"));
                thisProduct.setProdDesc(resultSet.getString("ProdDesc"));
                thisProduct.setProdPrice(resultSet.getString("ProdPrice"));
                thisProduct.setProdPictLocation(resultSet.getString("ProdPictLocation"));
                productArrayList.add(thisProduct);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeStatement(statement);
        }
        return productArrayList;
    }
}
