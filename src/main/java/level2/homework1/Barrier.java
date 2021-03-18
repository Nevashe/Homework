package level2.homework1;

public class Barrier implements let{

private int high;

    public Barrier(int high) {
        this.high = high;
    }

    @Override
    public void overcomeLet(Abilities barrier) {
        if (barrier.checkJump()){
            System.out.println("Успешно перепрыгнул");
        } else {
            System.out.println("Не смог перепрыгнуть");
        }
    }

    @Override
    public int highLet() {
        return high;
    }
    @Override
    public int lengthLet() {
        return 0;
    }
}
