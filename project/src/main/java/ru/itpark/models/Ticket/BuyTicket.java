package ru.itpark.models.Ticket;


import lombok.*;
import ru.itpark.models.User.User;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String ticketsName;
    private String ticketsCode;
    private LocalDateTime buyTime;
    private LocalDateTime buyEndTime;
    private int price;
    private int quantityAdult;
    private int quantityKids;
    private int adultPrice;
    private int kidsPrice;

    @Enumerated(value = EnumType.STRING)
    private TicketState ticketState;
}
