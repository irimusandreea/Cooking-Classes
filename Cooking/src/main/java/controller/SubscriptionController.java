package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import model.Subscription;
import model.CookingClass;
import service.Service;
import java.util.List;

public class SubscriptionController {

    @FXML
    private TableView<Subscription> table;
    @FXML
    private TextField participantField, phoneNrField, addressField, classField, cnameField;
    @FXML
    private Text idLabel;

    private Service service;
    private ObservableList<Subscription> objectsList = FXCollections.observableArrayList();

    public SubscriptionController() {
    }

    @FXML
    public void initialize() {
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldItem, newItem) -> show(newItem));
        table.setItems(objectsList);
    }

    private void show(Subscription newItem) {

        if (newItem == null)
            clearFields();
        else {
            idLabel.setText("" + newItem.getID());
            participantField.setText(newItem.getParticipant());
            phoneNrField.setText(newItem.getPhoneNr());
            addressField.setText(newItem.getAddress());
            classField.setText("" + newItem.getCookingClass());
        }

    }

    private void clearFields() {

        idLabel.setText("");
        participantField.setText("");
        phoneNrField.setText("");
        addressField.setText("");
        classField.setText("");

    }

    public void setService(Service serv) {

        this.service=serv;
        List<Subscription> lp=serv.getAll2();
        objectsList.addAll(lp);

    }

    @FXML
    private void add(ActionEvent e) {

        String p1= participantField.getText();
        String p2= phoneNrField.getText();
        String p3= addressField.getText();
        String p4= classField.getText();
        if ("".equals(p1)||"".equals(p2)||"".equals(p3)||"".equals(p4)){
            showErrorMessage("You need to complete all the fields!");
            return;
        }
        Subscription c=new Subscription(p1,p2,p3,p4);
        c=service.add2(c);
        objectsList.add(c);
        clearFields();

    }

    @FXML
    private void clear(ActionEvent e) {

        clearFields();
        table.getSelectionModel().clearSelection();

    }

    @FXML
    private void delete(ActionEvent e) {

        int selectedIndex=table.getSelectionModel().getSelectedIndex();
        if (selectedIndex<0) {
            showErrorMessage("You have to select an object from the table!");
            return;
        }else{
            objectsList.remove(selectedIndex);
        }

    }

    @FXML
    public void report(ActionEvent actionEvent) {

        String value=cnameField.getText();
        List reportResultList=service.getReport1(value);
        StringBuilder list= new StringBuilder();
        for (Object o:reportResultList)
            list.append(o).append("\n");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Report");
        if(list.length()==0){
            alert.setContentText("There are no subscriptions to the given class.");
        }
        else
            alert.setContentText(list.toString());
        alert.showAndWait();

    }

    void showErrorMessage(String text) {

        Alert message=new Alert(Alert.AlertType.ERROR);
        message.setTitle("Error message");
        message.setContentText(text);
        message.showAndWait();

    }

}
