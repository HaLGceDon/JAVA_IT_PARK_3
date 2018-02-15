package ru.itpark.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.forms.PayForm;
import ru.itpark.forms.TicketForm;
import ru.itpark.models.tickets.Tickets;
import ru.itpark.models.tickets.BuyTicket;
import ru.itpark.models.tickets.BuyTicketState;
import ru.itpark.models.users.User;
import ru.itpark.repositories.BuyTicketRepository;
import ru.itpark.repositories.TicketsRepository;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private BuyTicketRepository buyTicketRepository;

    @Autowired
    private AuthenticationService authenticationService;


    @Autowired
    private JavaMailSender javaMailSender;



    @SneakyThrows
    @Override
    public BuyTicket payTickets(PayForm payForm,
                                Authentication authentication) {
        if (payForm.getCardMonth()>0 & payForm.getCardMonth() < 13
                & payForm.getCardYear() >= 18
                & payForm.getCardNumber() != 0
                & payForm.getCardHolder() != null
                & payForm.getCardCvc() != 0){

            Tickets tickets = ticketsRepository.findTicketsByName(payForm.getName());
            LocalDateTime buyTime = LocalDateTime.now();
            String ticketCode = UUID.randomUUID().toString().replace("-","");
            User user = authenticationService.getUserByAuthentication(authentication);

            BuyTicket buyTicket = BuyTicket.builder()
                    .buyTime(buyTime)
                    .buyEndTime(buyTime.plusMonths(3))
                    .ticketsCode(ticketCode)
                    .ticketsName(tickets.getName())
                    .ticketState(BuyTicketState.PAID)
                    .user(user)
                    .quantityAdult(payForm.getQuantityAdult())
                    .quantityKids(payForm.getQuantityKids())
                    .price(payForm.getPrice())
                    .adultPrice(tickets.getAdultPrice())
                    .kidsPrice(tickets.getKidsPrice())
                    .build();
            buyTicketRepository.save(buyTicket);

            String text = "<p>Вы успешно совершили покупку, посмотреть подробности можно в личном кабинете:</p>\n" +
                    "<a href=\"http://localhost/profile\">Профиль</a>\n" +
                    "<p>Распечатайте или предьявите это письмо на входе.</p>"+
                    "<p>Ваш Код билета:</p>" + ticketCode + "<br><p> Никому его не сообщайте!</p>";

            MimeMessage message = javaMailSender.createMimeMessage();
            message.setContent(text, "text/html");
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(user.getEmail());
            messageHelper.setSubject("Покупка билета");
            messageHelper.setText(text, true);

            javaMailSender.send(message);

            return buyTicket;

        }else{
            return BuyTicket.builder()
                    .ticketState(BuyTicketState.NOT_PAID)
                    .quantityAdult(payForm.getQuantityAdult())
                    .quantityKids(payForm.getQuantityKids())
                    .price(payForm.getPrice())
                    .build();
        }
    }


    @Override
    public BuyTicket getBuyTickets(PayForm form) {
        Tickets tickets = ticketsRepository.findTicketsByName(form.getName());
        int price = form.getQuantityKids()* tickets.getKidsPrice() + form.getQuantityAdult()* tickets.getAdultPrice();
        return BuyTicket.builder()
                .price(price)
                .quantityAdult(form.getQuantityAdult())
                .quantityKids(form.getQuantityKids())
                .build();
    }

    @Override
    public List<BuyTicket> getBuyTicketsByUser(Authentication authentication) {
        User user = authenticationService.getUserByAuthentication(authentication);
        return buyTicketRepository.findBuyTicketByUser(user);
    }

    @Override
    public int buyAdultTicketsSum(PayForm buyForm){
        Tickets tickets = ticketsRepository.findTicketsByName(buyForm.getName());
        return buyForm.getQuantityAdult()* tickets.getAdultPrice();
    }

    @Override
    public int buyKidsTicketsSum(PayForm buyForm){
        Tickets tickets = ticketsRepository.findTicketsByName(buyForm.getName());
        return buyForm.getQuantityKids()* tickets.getKidsPrice();
    }

    @Override
    public List<Tickets> getTickets() {

        List<Tickets> tickets = ticketsRepository.findAll();
        tickets.sort(Comparator.comparing(Tickets::getId));
        return tickets;
    }

    @Override
    public Tickets getTicketByName(String name) {
        return ticketsRepository.findTicketsByName(name);
    }

    @Override
    public String newTicket(TicketForm ticketForm) {
        Tickets newTicket = Tickets.builder()
                .adultPrice(ticketForm.getAdultPrice())
                .kidsPrice(ticketForm.getKidsPrice())
                .name(ticketForm.getName())
                .tittle(ticketForm.getTittle())
                .specification(ticketForm.getSpecification())
                .build();
        ticketsRepository.save(newTicket);
        return newTicket.getName();
    }

    @Override
    public String deleteTicket(String name) {
        Tickets ticket = ticketsRepository.findTicketsByName(name);
        ticketsRepository.delete(ticket.getId());
        return ticket.getName();
    }

    @Override
    public void updateTicket(TicketForm ticketForm) {
        Tickets ticket = ticketsRepository.findTicketsByName(ticketForm.getName());
        ticketForm.update(ticket);
        ticketsRepository.save(ticket);
    }

}
