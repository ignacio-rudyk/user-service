package com.accenture.userservice.model.dto;

public class PaymentMethodDTO {

    private Long id;

    private String name;

    public PaymentMethodDTO() {
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

    @Override
    public String toString() {
        return "PaymentMethodDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
