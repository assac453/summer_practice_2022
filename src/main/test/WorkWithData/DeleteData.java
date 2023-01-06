package WorkWithData;

import GUI.Backend.SQL.SQLConnection;
import GUI.Backend.SQL.WorkWithData;
import GUI.Backend.Toys.Toys;
import javafx.collections.ObservableList;

public class DeleteData {
    public static void main(String[] args) {
        WorkWithData a = new WorkWithData();
        ObservableList<Toys> list = SQLConnection.getDataProducts();
        for(Toys b : list){
            a.delete(b.getId());
        }
    }
}
