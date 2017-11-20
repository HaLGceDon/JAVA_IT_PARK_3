package ru.itpark;

public class Main {
    public static void main(String[] args) {
        Human marsel = new Human("Марсель", 23, 178);
        Human lex = new Human("Алексей", 27, 189);
        Human almaz = new Human("Алмаз", 25, 176);
        Human zagir = new Human("Загир", 26,193);
        Human mars = new Human("Марс", 24, 188);
        Human radik = new Human("Радик", 24, 177);
        Human anton = new Human("Антон", 18, 166);

        ArrayList<Human> humans = new ArrayList<>();
        humans.add(mars);
        humans.add(marsel);
        humans.add(radik);
        humans.add(almaz);
        humans.add(anton);
        humans.add(zagir);
        humans.add(lex);

        Comporator comporator1 = new HumanHeightComporator();
        for (int i = humans.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ( comporator1.compare(humans.get(j), humans.get(j+1)) < 0) {
                    humans.swap(j,  j + 1);
                }
            }

        }

        for (int i = 0; i < humans.size(); i++) {
            System.out.println(humans.get(i));
        }

        System.out.println();

        Comporator comporator = new HumanAgeComporator();
        for (int i = humans.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if ( comporator.compare(humans.get(j), humans.get(j+1)) < 0) {
                    humans.swap(j,  j + 1);
                }
            }

        }

        for (int i = 0; i < humans.size(); i++) {
            System.out.println(humans.get(i));
        }






    }
}