package VasiliGrigorev;


public class Main {

    public static void main(String[] args) {

        Human dima = new Human("Dima", 29, 180, 80);
        Human lera = new Human("Lera", 25, 172, 55);
        Human lennon = new Human("Lennon", 27, 176, 82);

        Human humans[] =  {dima, lera, lennon} ;
        Human humans1[] =  {dima, lera, lennon} ;

        Comporator comporator = new ComparatorByAge();
        Sorter sorter = new SortBySelection();

        sorter.sorter(comporator, humans);


        for (int i=0; i < humans.length; i++) {
            System.out.println(humans[i].name + " " + humans[i].getAge() + " " + humans[i].getHeight() + " " + humans[i].getWeight());
        }


        System.out.println();


        Comporator comporator1 = new ComparatotByHeight();
        Sorter sorter1 = new SorterBubles();

        sorter1.sorter(comporator1, humans1);

        for (int i=0; i < humans.length; i++) {
            System.out.println(humans1[i].name + " " + humans1[i].getAge() + " " + humans1[i].getHeight() + " " + humans1[i].getWeight());
        }
    }
}
