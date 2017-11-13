package com.company;

public class Main {

    public static void main(String[] args) {

        Broadcast utro = new Broadcast("Утро",800, 900);
        Broadcast novosti = new Broadcast("Новости",901, 1000);
        Broadcast kriminal = new Broadcast("Криминальная Россия",901, 1000);
        Broadcast kulinarShow = new Broadcast("Кулинfрное шоу",1001, 1200);
        Broadcast kriminalKulinar = new Broadcast("Криминальный кулинар",1001, 1200);
        Broadcast newShow = new Broadcast("Новое шоу",1201, 1400);
        Broadcast oldShow = new Broadcast("Старое шоу",1201, 1400);
        Broadcast film = new Broadcast("Кинофильм",1401, 1600);

        Broadcast firstChannel0[] = {utro, novosti, kulinarShow, newShow, film};
        Broadcast ntv0[] = {utro, kriminal, kriminalKulinar, oldShow, film};

        Channel firstChannel = new Channel(firstChannel0);
        Channel ntv = new Channel(ntv0);

        Channel tv0[] = {firstChannel, ntv};

        Tv tv = new Tv (tv0);

        Remote remote = new Remote(tv);



    }
}