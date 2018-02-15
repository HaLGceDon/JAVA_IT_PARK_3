package ru.itpark.models.ticket;


import lombok.*;
import ru.itpark.models.file.FileInfo;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private int adultPrice;
    private int kidsPrice;
    private String tittle;
    private String specification;

    @OneToOne
    @JoinColumn
    private FileInfo image;
}
