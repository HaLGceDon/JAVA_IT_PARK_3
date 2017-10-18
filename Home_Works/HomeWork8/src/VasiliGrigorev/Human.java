package VasiliGrigorev;

public class Human {

    public String name;
    private int age;
    private int height;
    private int weight;



    public  Human (String name, int age, int height, int weight) {
        setName(name);
        setAge(age);
        setHeight(height);
        setWeight(weight);
    }



    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.err.println("Возраст некорректный.");
            this.age = 0;
        }
    }

    public void setHeight(int height) {
        if (height >= 0) {
        this.height = height;}
        else this.height = 0;
    }

    public void setWeight(int weight) {
        if (weight >= 0) {
            this.weight = weight;}
           else this.weight = 0;
        }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }



}
