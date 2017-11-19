package ru.itpark;

public class Main {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.put("Марсель");
        set.put("Илья");
        set.put("Антон");
        set.put("Артем");
        set.put("Степан");
        set.put("Владимир");
        set.put("Никита");
        set.put("Гавриил");
        set.put("Константин");
        set.put("Дмитрий");
        set.put("Вячеслав");
        set.put("Василий");
        set.put("Игорь");
        set.put("Аркадий");
        set.put("Икакий");
        set.put("Ксюша");
        set.put("Нюша");
        set.put("Хрюша");
        set.put("Святослав");
        set.put("Вячеслав");
        set.put("Бедокур");
        set.put("Джаванепоймун");
        set.put("Слава");

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            iterator.printNext();
        }

    }
}