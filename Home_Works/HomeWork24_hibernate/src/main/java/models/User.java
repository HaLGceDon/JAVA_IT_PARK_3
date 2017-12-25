package models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "cars")
@Builder
public class User {
  private Long id;
  private String name;
  private int age;
  private int height;
  private List<Car> cars;
}
