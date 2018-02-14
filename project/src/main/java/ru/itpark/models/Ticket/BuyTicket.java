package ru.itpark.models.ticket;


import lombok.*;
import ru.itpark.models.file.FileInfo;
import ru.itpark.models.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class BuyTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ticketsName;
    private String ticketsCode;
    private LocalDateTime buyTime;
    private LocalDateTime buyEndTime;
    private int price;
    private int quantityAdult;
    private int quantityKids;
    private int adultPrice;
    private int kidsPrice;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OrderBy
    @Enumerated(value = EnumType.STRING)
    private BuyTicketState ticketState;
}
