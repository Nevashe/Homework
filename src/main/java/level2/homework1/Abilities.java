package level2.homework1;

public interface Abilities {
    void run(Road runRoad);
    void jump(Barrier barrier);
    boolean checkRun();
    boolean checkJump();
    int howCanRan();
    int howCanJump();
    int maxHighJump();
}
