package ru.itpark.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String breed;
    private String color;
    private String health;
    private int weight;

}
