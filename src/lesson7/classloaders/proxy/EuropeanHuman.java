package lesson7.classloaders.proxy;

public class EuropeanHuman implements Human {
    @Override
    public void eat(String name, int count) {
        System.out.println("Human have not eat" + name + " " + count);
    }

    @Override
    public void sleep(int time) {
        System.out.println("EuropeanHuman dont sleep " + time + " hours");
    }

    @Override
    public String talk() {
        return "EuropeanHuman say BAY";
    }
}
