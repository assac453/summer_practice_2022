package receivingData;

import GUI.Backend.SQL.SQLConnection;
import GUI.Backend.Toys.Toys;
import javafx.collections.ObservableList;

public class ReceivingData {
    public static void main(String[] args) {
        ObservableList<Toys> list = SQLConnection.getDataProducts();
        for ( Toys a : list)
            a.showAll();
    }
}
