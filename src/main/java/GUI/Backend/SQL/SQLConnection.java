package GUI.Backend.SQL;

import GUI.Backend.Toys.Toys;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQLConnection {
    private Connection conn = null;
    public static Connection ConnectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/DataBaseStudy","root","");
            return conn;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static ObservableList<Toys> getDataProducts(){
        Connection conn = ConnectionDB();
        ObservableList<Toys> list = FXCollections.observableArrayList();
        try {
            assert conn != null;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ToysShop");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Toys(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getLong("articul"),
                        rs.getString("manufacture"),
                        rs.getString("dateCome"),
                        rs.getString("dateSell"),
                        rs.getString("type"),
                        rs.getDouble("price")
                ));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
