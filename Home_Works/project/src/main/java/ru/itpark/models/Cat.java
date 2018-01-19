package ru.itpark.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Cat {
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
