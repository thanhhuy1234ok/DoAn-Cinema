package com.green.cinema.models;

public class AccountNV {
    private String account;
    private String password;

    public AccountNV(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AccountNV(){
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
