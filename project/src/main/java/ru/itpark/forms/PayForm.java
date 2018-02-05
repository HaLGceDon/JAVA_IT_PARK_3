package ru.itpark.forms;

import lombok.Data;

@Data
public class PayForm {
    private long cardNumber;
    private int cardMonth;
    private int cardYear;
    private  int cardCvc;
    private String cardHolder;
    private int price;
    private int quantityAdult;
    private int quantityKids;
}
