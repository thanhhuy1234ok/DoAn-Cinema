package com.green.cinema.controllers;

import com.green.cinema.dbheper.Daos.ManagerDao;
import com.green.cinema.models.StaffManager;
import com.green.cinema.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class StaffManagerController extends BaseController implements Initializable {
    public StaffManagerController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    ObservableList<StaffManager> listManager;
    ManagerDao managerDao = new ManagerDao();
    StaffManager staffManager = new StaffManager();

    private int currentIndex = 0;

    @FXML
    private TableView<StaffManager> tableManager;

    @FXML
    private TableColumn<StaffManager, Integer> tb_ID;

    @FXML
    private TableColumn<StaffManager, String> tb_HoTen;

    @FXML
    private TableColumn<StaffManager, String> tb_Email;

    @FXML
    private TableColumn<StaffManager, String> tb_Address;

    @FXML
    private TableColumn<StaffManager, Integer> tb_Phone;

    @FXML
    private TableColumn<StaffManager, String> tb_Birth;

    @FXML
    private TableColumn<StaffManager, ComboBox> tb_Position;

    @FXML
    private Button bt_Add;

    @FXML
    private Button bt_Del;

    @FXML
    void buttonAddAction(ActionEvent event) {
        viewFactory.showAddWindow();
        Stage stage = (Stage) this.bt_Add.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @FXML
    void buttonDelAction(ActionEvent event) {
        StaffManager seleted = tableManager.getSelectionModel().getSelectedItem();
        listManager.remove(seleted);
        managerDao.deletenhanvien(viewFactory.getDbManager().getDBConnection(), seleted.getId());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listManager = FXCollections.observableArrayList();

        tb_ID.setCellValueFactory(new PropertyValueFactory<StaffManager, Integer>("id"));
        tb_HoTen.setCellValueFactory(new PropertyValueFactory<StaffManager, String>("hoTen"));
        tb_Email.setCellValueFactory(new PropertyValueFactory<StaffManager, String>("email"));
        tb_Address.setCellValueFactory(new PropertyValueFactory<StaffManager, String>("address"));
        tb_Phone.setCellValueFactory(new PropertyValueFactory<StaffManager, Integer>("phone"));
        tb_Birth.setCellValueFactory(new PropertyValueFactory<StaffManager, String>("birth"));
        tb_Position.setCellValueFactory(new PropertyValueFactory<StaffManager, ComboBox>("position"));

        ArrayList<StaffManager> listNV = managerDao.getAllManager(viewFactory.getDbManager().getDBConnection());
        listManager.setAll(listNV);

        tableManager.setItems(listManager);
        tableManager.getSelectionModel().select(currentIndex);

        tableManager.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> change) {
                for (int index : change.getList()) {
                    System.out.println("change list: " + index);
                }
            }
        });
    }
}
