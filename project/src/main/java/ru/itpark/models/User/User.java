package ru.itpark.models.user;

import lombok.*;
import ru.itpark.models.ticket.BuyTicket;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int age;
  private String surname;
  private String login;
  private String hashPassword;
  private String email;
  private LocalDateTime registrationTime;
  private String confirmCode;
  private String passwordRecoveryCode;

  @Enumerated(value = EnumType.STRING)
  private State state;

  @Enumerated(value = EnumType.STRING)
  private Role role;

}