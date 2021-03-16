package level2.homework1;

public class Cat implements Abilities{

    @Override
    public void run(Road runRoad) {
        System.out.println("Кот не может бежать");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Кот прыгает");
    }
}
