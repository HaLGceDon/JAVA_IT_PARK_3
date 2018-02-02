package ru.itpark.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.forms.BuyForm;
import ru.itpark.forms.PayForm;
import ru.itpark.models.User;
import ru.itpark.repositories.UsersRepository;

@Service
public class TicketsServiceImpl implements TicketsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public int buyTickets(BuyForm form) {
        int result = form.getQuantityKids()*300 + form.getQuantityAdult()*600;

        return result;
    }


    @Override
    public boolean payTickets(PayForm form) {
        if (form.getCardMonth()>0 & form.getCardMonth() < 13
                & form.getCardYear() >= 18
                & form.getCardNumber() != 0
                & form.getCardHolder() != null
                & form.getCardCvc() != 0){
           return true;
        }else return false;
    }
}
