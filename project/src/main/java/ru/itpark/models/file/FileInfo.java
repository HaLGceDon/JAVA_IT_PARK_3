package ru.itpark.models.file;

import lombok.*;
import ru.itpark.models.users.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class FileInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private String viewName;
  private String destination;
  private String storageName;
  private String originalName;

  private long size;
  private String type;
  private String url;
}
