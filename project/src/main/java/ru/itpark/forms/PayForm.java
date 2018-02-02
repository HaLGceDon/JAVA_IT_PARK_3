package ru.itpark.forms;

import lombok.Data;

@Data
public class PayForm {
    private int price;
    private int cardNumber;
    private int cardMonth;
    private int cardYear;
    private int cardCvc;
    private String cardHolder;
}
