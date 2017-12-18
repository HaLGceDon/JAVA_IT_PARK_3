package ru.itpark.models;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "cars")
@Builder
public class Human {
    private int id;
    private String name;
    private int age;
    private int height;
    private List<Car> cars;
}