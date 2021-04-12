package com.green.cinema.controllers;

import com.green.cinema.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainAdmin extends  BaseController {

    public MainAdmin(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    private String TAG = "MainWindowController";

    @FXML
    void menuOptionAction(ActionEvent event) {
        System.out.println(TAG + "::menuOptionAction()");
        viewFactory.showOptionWidow();
    }

    @FXML
    void menuManagerAction(ActionEvent event) {
        System.out.println(TAG + "::menuManagerAction()");
        viewFactory.showStaffWindow();
    }

}
