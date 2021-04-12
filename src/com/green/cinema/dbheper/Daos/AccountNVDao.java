package com.green.cinema.dbheper.Daos;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountNVDao {
    private static final String QUERY_TK_NHANVIEN = "SELECT COUNT(*)  from tknhanvien WHERE EMAIL =? And PASS =? " ;
    public AccountNVDao(){
    }
    String stError = "";

    public boolean checkAccount(Connection connection, String username, String password){
        try {
            PreparedStatement ps = connection.prepareStatement(QUERY_TK_NHANVIEN);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet queryresut = ps.executeQuery();
            while (queryresut.next()){
                if (queryresut.getInt(1) == 1){
                    return true;
                }else {
                    stError = "Sai tên đăng nhập hoặc mật khẩu";
                    alterError(stError);
                    return false;

                }
            }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
              stError = "Lỗi đăng nhập";
              alterError(stError);
            return false;
        }
        return false;
    }

    public void  alterError(String st){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Lỗi đăng nhập");
        alert.setContentText(st);

        ButtonType buttonTypeOk = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(buttonTypeOk);
        alert.show();
    }
}
