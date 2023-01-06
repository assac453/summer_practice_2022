package GUI.Backend.Controllers;

import GUI.Backend.SQL.WorkWithData;
import GUI.Backend.Toys.Toys;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Pattern;

public class CreateController {

    @FXML
    private TextField typeField;
    @FXML
    private TextField articulField;

    @FXML
    private Button cancelButton;

    @FXML
    private DatePicker dateComePicker;

    @FXML
    private DatePicker dateSellPicker;

    @FXML
    private TextField manufactureField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private Button saveButton;
    private Toys toy;
    @FXML
    private void initialize(){
        dateComePicker.setEditable(false);
        dateSellPicker.setEditable(false);
    }
    @FXML
    void cancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void saveButtonClicked(ActionEvent event) {
        if(nameField.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле наименование не может быть пустым");
            alert.showAndWait();

        }
        else if (articulField.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле артикул не может быть пустым");
            alert.showAndWait();

        }
        else if (manufactureField.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле производитель не может быть пустым");
            alert.showAndWait();

        }
        else if (dateComePicker.getValue().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле дата поступления не может быть пустым");
            alert.showAndWait();

        }
        else if (dateSellPicker.getValue().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле дата продажи не может быть пустым");
            alert.showAndWait();

        }
        else if (typeField.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле тип не может быть пустым");
            alert.showAndWait();

        }
        else if (priceField.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setTitle("Ошибка");
            alert.setContentText("Поле цена не может быть пустым");
            alert.showAndWait();

        }
        else {

            if (!Pattern.matches("\\d+",articulField.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setTitle("Ошибка");
                alert.setContentText("В поле артикул принимаются только целые числа");
                alert.showAndWait();

            } else if (!dateComePicker.getValue().isEqual(dateSellPicker.getValue()) && dateComePicker.getValue().isAfter(dateSellPicker.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setTitle("Ошибка");
                alert.setContentText("Дата поступления не может быть позже даты продажи");
                alert.showAndWait();
            }
            else if (!Pattern.matches("\\d+\\.?\\d+",priceField.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setTitle("Ошибка");
                alert.setContentText("В поле цена принимаются дробные числа");
                alert.showAndWait();
            }
            else {
                WorkWithData wwd = new WorkWithData();
                wwd.add(new Toys(
                        0,
                        nameField.getText(),
                        Long.parseLong(articulField.getText()),
                        manufactureField.getText(),
                        String.valueOf(dateComePicker.getValue()),
                        String.valueOf(dateSellPicker.getValue()),
                        typeField.getText(),
                        Double.parseDouble(priceField.getText())
                ));
                cancelButtonClicked(event);
            }
        }
    }

}
