package com.accenture.userservice.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private BigDecimal amount;

    private LocalDate createdAt;

    private Long paymentMethodId;

    private String cbu;

    public TransactionDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
}
