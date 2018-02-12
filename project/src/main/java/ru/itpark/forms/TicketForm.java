package ru.itpark.forms;

import lombok.Data;
import ru.itpark.models.ticket.Tickets;

@Data
public class TicketForm {
    private Long id;
    private String name;
    private String tittle;
    private String specification;
    private int adultPrice;
    private int kidsPrice;

    public void update(Tickets tickets) {
        tickets.setName(this.name);
        tickets.setTittle(this.tittle);
        tickets.setSpecification(this.specification);
        tickets.setAdultPrice(this.adultPrice);
        tickets.setKidsPrice(this.kidsPrice);
    }
}
