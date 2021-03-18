package level2.homework1;

public class Cat implements Abilities{

    private boolean checkRun = false;
    private boolean checkJump = true;
    private int howCanRan = 10;
    private int howCanJump = 4;
    private int maxHighJump = 2;

    @Override
    public void run(Road runRoad) {
        System.out.println("Кот не может бежать");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Кот прыгает");
    }

    @Override
    public boolean checkRun() {
        return checkRun;
    }

    @Override
    public boolean checkJump() {
        return checkJump;
    }

    @Override
    public int howCanRan() {
        return howCanRan;
    }

    @Override
    public int howCanJump() {
        return howCanJump;
    }

    @Override
    public int maxHighJump() {
        return maxHighJump;
    }
}
