package com.accenture.userservice.model;

import java.math.BigDecimal;

public class Account {

    private Long id;

    private String numberAccount;

    private BigDecimal funds;

    private String cbu;

    private Long userId;

    public Account() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", funds=" + funds +
                ", cbu='" + cbu + '\'' +
                ", numberAccount='" + numberAccount + '\'' +
                ", userId=" + userId +
                '}';
    }
}
