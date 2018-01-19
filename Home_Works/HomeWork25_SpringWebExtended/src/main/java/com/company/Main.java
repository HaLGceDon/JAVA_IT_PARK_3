package com.company;

import com.company.models.User;
import com.company.repository.UsersRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("context.xml");
        UsersRepository usersRepository = classPathXmlApplicationContext.getBean(UsersRepository.class);
        System.out.println(usersRepository.findAll());

        User superMan = User.builder()
                .name("упермен")
                .age(102)
                .build();

        usersRepository.save(superMan);
    }
}
