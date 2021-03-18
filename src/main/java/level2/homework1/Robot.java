package level2.homework1;

public class Robot implements Abilities{

    private boolean checkRun = true;
    private boolean checkJump = false;


    private int howCanRan = 40;
    private int howCanJump = 6;
    private int maxHighJump = 4;

    @Override
    public void run(Road runRoad) {
        System.out.println("Робот бежит");
    }

    @Override
    public void jump(Barrier barrier) {
        System.out.println("Робот не может прыгать");
    }

    @Override
    public boolean checkRun() {
        return false;
    }

    @Override
    public boolean checkJump() {
        return false;
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
