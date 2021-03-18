package level2.homework1;

public class Person implements Abilities{

    private boolean checkRun = true;
    private boolean checkJump = true;
    private int howCanRan = 30;
    private int howCanJump = 2;
    private int maxHighJump = 2;

    @Override
    public void run(Road runRoad) {
        System.out.println("Человек бежит");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Человек прыгает");
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