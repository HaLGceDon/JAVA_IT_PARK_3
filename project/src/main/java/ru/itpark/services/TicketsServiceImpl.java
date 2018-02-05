package ru.itpark.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.models.Ticket.BuyTicket;
import ru.itpark.models.Ticket.TicketState;
import ru.itpark.models.Ticket.Tickets;
import ru.itpark.models.User.User;
import ru.itpark.repositories.BuyTicketRepository;
import ru.itpark.repositories.TicketsRepository;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    TicketsRepository ticketsRepository;

    @Autowired
    BuyTicketRepository buyTicketRepository;

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

            Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
            LocalDateTime buyTime = LocalDateTime.now();
            String ticketCode = UUID.randomUUID().toString().replace("-","");
            User user = authenticationService.getUserByAuthentication(authentication);

            BuyTicket buyTicket = BuyTicket.builder()
                    .buyTime(buyTime)
                    .buyEndTime(buyTime.plusMonths(3))
                    .ticketsCode(ticketCode)
                    .ticketsName("zooMain")
                    .ticketState(TicketState.PAID)
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
            BuyTicket errorTickets = BuyTicket.builder()
                    .ticketState(TicketState.NOT_PAID)
                    .quantityAdult(payForm.getQuantityAdult())
                    .quantityKids(payForm.getQuantityKids())
                    .price(payForm.getPrice())
                    .build();
            return errorTickets;
        }
    }


    @Override
    public BuyTicket getBuyTicketsZooMain(BuyForm form) {
        Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
        int price = form.getQuantityKids()*tickets.getKidsPrice() + form.getQuantityAdult()*tickets.getAdultPrice();
        return BuyTicket.builder()
                .price(price)
                .quantityAdult(form.getQuantityAdult())
                .quantityKids(form.getQuantityKids())
                .build();
    }

    @Override
    public List<BuyTicket> getBuyTicketByUser(Authentication authentication) {
        User user = authenticationService.getUserByAuthentication(authentication);
        List<BuyTicket> list = buyTicketRepository.findBuyTicketByUser(user);
        return list;
    }

    @Override
    public int buyAdultTicketsSumZooMain(BuyForm buyForm){
        Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
        int result = buyForm.getQuantityAdult()*tickets.getAdultPrice();
        return result;
    }

    @Override
    public int buyKidsTicketsSumZooMain(BuyForm buyForm){
        Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
        int result = buyForm.getQuantityKids()*tickets.getKidsPrice();
        return result;
    }

    @Override
    public int getAdultBuyPriceZooMain() {
        Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
        return tickets.getAdultPrice();
    }

    @Override
    public int getKidsBuyPriceZooMain() {
        Tickets tickets = ticketsRepository.findTicketsByName("zooMain");
        return tickets.getKidsPrice();
    }



}
