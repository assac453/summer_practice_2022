package GUI.Backend.Controllers;

import GUI.Backend.SQL.SQLConnection;
import GUI.Backend.SQL.WorkWithData;
import GUI.Backend.Toys.Toys;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private TableView<Toys> TableToys;
    @FXML
    private TableColumn<Toys, String> nameColumn;
    @FXML
    private TableColumn<Toys, Long> articulColumn;
    @FXML
    private TableColumn<Toys, String> manufactureColumn;
    @FXML
    private TableColumn<Toys, String> dateComeColumn;
    @FXML
    private TableColumn<Toys, String> dateSellColumn;
    @FXML
    private TableColumn<Toys, String> typeColumn;
    @FXML
    private TableColumn<Toys, Double> priceColumn;
    @FXML
    private Button create;
    @FXML
    private Button edit;
    @FXML
    private Button delete;
    @FXML
    private TextField search;
    private Toys toy;
    private ObservableList<Toys> toysList;
    private WorkWithData wwd = new WorkWithData();
    @FXML
    private void initialize() throws Exception{
        TableToys.getSelectionModel().getSelectedItem();
        TableToys.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventEventHandler);
        loadData();
    }
    private void loadData() throws Exception {
        nameColumn.setCellValueFactory(new PropertyValueFactory<Toys,String>("name"));
        articulColumn.setCellValueFactory(new PropertyValueFactory<Toys,Long>("articul"));
        manufactureColumn.setCellValueFactory(new PropertyValueFactory<Toys,String>("manufacture"));
        dateComeColumn.setCellValueFactory(new PropertyValueFactory<Toys,String>("dateCome"));
        dateSellColumn.setCellValueFactory(new PropertyValueFactory<Toys,String>("dateSell"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Toys,String>("type"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Toys,Double>("price"));
        toysList = SQLConnection.getDataProducts();
        TableToys.setItems(toysList);
        search();
    }
    private void search() throws Exception {
        FilteredList<Toys> filteredData = new FilteredList<>(toysList, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(oneToy -> {
                if (newValue == null || newValue.isEmpty()) { return true; }
                String lowerCaseFilter = newValue.toLowerCase();
                if (oneToy.getName().toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (oneToy.getDateCome().toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (oneToy.getDateSell().toLowerCase().toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (String.valueOf(oneToy.getPrice()).toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (String.valueOf(oneToy.getArticul()).toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (oneToy.getManufacture().toLowerCase().contains(lowerCaseFilter)) { return true; }
                else if (oneToy.getType().toLowerCase().contains(lowerCaseFilter)) { return true; }
                else return false;
            });
        });
        SortedList<Toys> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TableToys.comparatorProperty());
        TableToys.setItems(sortedData);
    }
    private EventHandler<MouseEvent> mouseEventEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            toy = TableToys.getSelectionModel().getSelectedItem();
        }
    };
    @FXML
    void createButton(ActionEvent event) throws IOException {
        toy=null;
        Stage addItemStage = new Stage();
        FXMLLoader addItemFxmlLoader = new FXMLLoader(getClass().getResource("/Frontend/CreateWindow.fxml"));
        Scene addItemScene = new Scene(addItemFxmlLoader.load());

        addItemStage.setOnHiding(e -> {
            try {
                loadData();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        addItemStage.setResizable(false);
        addItemStage.setTitle("Добавить");
        addItemStage.setScene(addItemScene);

        addItemStage.initModality(Modality.WINDOW_MODAL);
        addItemStage.initOwner(((Node) event.getSource()).getScene().getWindow());

        addItemStage.show();
        addItemStage.centerOnScreen();
    }

    @FXML
    void deleteButton(ActionEvent event) throws Exception {
        if(toy==null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Не выбрано поле.");
            alert.setContentText("Поле для удаления не выбрано. Выберете поле и повторите.");
            alert.showAndWait();
        }else {
            wwd.delete(toy.getId());
            loadData();
        }

    }

    @FXML
    void editButton(ActionEvent event) throws Exception {
        Stage editStage = new Stage();
        FXMLLoader editFxmlLoader = new FXMLLoader(getClass().getResource("/Frontend/EditWindow.fxml"));
        Scene editItemScene = new Scene(editFxmlLoader.load());

        EditController editItemController = editFxmlLoader.getController();

        editStage.setOnHiding(e -> {
            try {
                loadData();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        if(toy == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Продукт для редактирования не выбран");
            alert.setContentText("Выберите позицию и повторите попытку");
            alert.showAndWait();
        } else {
            editItemController.setTextFields(toy);

            editStage.setResizable(false);
            editStage.setTitle("Редактировать");
            editStage.setScene(editItemScene);

            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(((Node) event.getSource()).getScene().getWindow());
            editStage.setOnHiding(e -> {
                try {
                    loadData();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            editStage.show();
            editStage.centerOnScreen();
        }
        toy = null;
        loadData();
    }



}
