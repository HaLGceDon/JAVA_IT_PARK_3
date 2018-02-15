package ru.itpark.forms;

import lombok.Data;
import ru.itpark.models.users.User;

@Data
public class NamesForm {
  private String name;
  private String surname;
  private int age;

  public void update(User user) {
    user.setName(this.name);
    user.setSurname(this.surname);
    user.setAge(this.age);
  }

}
