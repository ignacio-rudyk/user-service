package com.accenture.userservice.model;

public class PaymentMethod {

    private Long id;

    private String name;

    private String beanOperationPayment;

    public PaymentMethod() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeanOperationPayment() {
        return beanOperationPayment;
    }

    public void setBeanOperationPayment(String beanOperationPayment) {
        this.beanOperationPayment = beanOperationPayment;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beanOperationPayment='" + beanOperationPayment + '\'' +
                '}';
    }
}
