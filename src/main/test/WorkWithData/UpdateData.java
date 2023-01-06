package WorkWithData;

import GUI.Backend.SQL.SQLConnection;
import GUI.Backend.SQL.WorkWithData;
import GUI.Backend.Toys.Toys;
import javafx.collections.ObservableList;

public class UpdateData {
    public static void main(String[] args) {
        WorkWithData a = new WorkWithData();
        ObservableList<Toys> b = SQLConnection.getDataProducts();
        for(Toys c : b){
            a.update(new Toys(c.getId(),"asd", 4321, "Russia", "2020-03-05","2021-03-05", "Ferrum", 123));
        }
//        a.update(new Toys(3, "asd", 4321, "USA", "2020-03-05","2021-03-05", "Ferrum", 123));
    }
}
