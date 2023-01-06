package GUI.Backend.SQL;

import GUI.Backend.Toys.Toys;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkWithData {
    public void add(Toys toy){
        try {
            Connection conn = SQLConnection.ConnectionDB();
            PreparedStatement pst = conn.prepareStatement("INSERT INTO ToysShop(name,articul,manufacture,dateCome,dateSell,type,price) values (?,?,?,?,?,?,?)");
            pst.setString(1,toy.getName());
            pst.setLong(2,toy.getArticul());
            pst.setString(3,toy.getManufacture());
            pst.setString(4,toy.getDateCome());
            pst.setString(5,toy.getDateSell());
            pst.setString(6,toy.getType());
            pst.setDouble(7,toy.getPrice());
            pst.executeUpdate();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            Connection conn = SQLConnection.ConnectionDB();
            PreparedStatement pst = conn.prepareStatement("DELETE FROM ToysShop WHERE id="+String.valueOf(id));
                pst.executeUpdate();
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Toys toy){
        try {
            Connection conn = SQLConnection.ConnectionDB();
            PreparedStatement pst = conn.prepareStatement("UPDATE ToysShop SET name=?, articul=?, manufacture=?, dateCome=?, dateSell=?, type=?, price=? WHERE id="+String.valueOf(toy.getId()));
            pst.setString(1,toy.getName());
            pst.setLong(2,toy.getArticul());
            pst.setString(3,toy.getManufacture());
            pst.setString(4,toy.getDateCome());
            pst.setString(5,toy.getDateSell());
            pst.setString(6,toy.getType());
            pst.setDouble(7,toy.getPrice());
            pst.executeUpdate();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
