package ru.itpark.forms;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DogsForm {
    private String name;
    private int age;
    private String breed;
    private String color;
    private String health;
    private int weight;
}
