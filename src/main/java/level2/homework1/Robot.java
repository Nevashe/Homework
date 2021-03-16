package level2.homework1;

public class Robot implements Abilities{

    @Override
    public void run(Road runRoad) {
        System.out.println("Робот бежит");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Робот не может прыгать");
    }
}
