package level2.homework1;

public class Person implements Abilities{

    @Override
    public void run(Road runRoad) {
        System.out.println("Человек бежит");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Человек прыгает");
    }
}