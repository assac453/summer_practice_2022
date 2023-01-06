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

import java.time.LocalDate;
import java.util.regex.Pattern;

public class EditController {

    @FXML
    private TextField articulField;

    @FXML
    private Button cancelButton;

    @FXML
    private DatePicker dateComePicker;

    @FXML
    private DatePicker dateSellPicker;

    @FXML
    private Button editButton;

    @FXML
    private TextField manufactureField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField typeField;
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
    void editButtonClicked(ActionEvent event) {
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

            if (!Pattern.matches("\\d+", articulField.getText())) {
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
            } else if (!Pattern.matches("\\d+\\.?\\d+", priceField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Ошибка");
                alert.setTitle("Ошибка");
                alert.setContentText("В поле цена принимаются дробные числа");
                alert.showAndWait();
            } else {
                toy.setId(toy.getId());
                toy.setName(nameField.getText());
                toy.setArticul(Long.parseLong(articulField.getText()));
                toy.setManufacture(manufactureField.getText());
                toy.setType(typeField.getText());
                toy.setDateCome(String.valueOf(dateComePicker.getValue()));
                toy.setDateSell(String.valueOf(dateSellPicker.getValue()));
                WorkWithData wwd = new WorkWithData();
                wwd.update(toy);
                cancelButtonClicked(event);
            }
        }

    }

    public void setTextFields(Toys toy) {
        this.toy = toy;
        nameField.setText(toy.getName());
        typeField.setText(toy.getType());
        priceField.setText(String.valueOf(toy.getPrice()));
        manufactureField.setText(toy.getManufacture());
        articulField.setText(String.valueOf(toy.getArticul()));
        dateComePicker.setValue(LocalDate.parse(toy.getDateCome()));
        dateSellPicker.setValue(LocalDate.parse(toy.getDateSell()));
    }
}
