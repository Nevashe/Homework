package level2.homework1;

public class Road implements let{
    public Road(int length) {
        this.length = length;
    }
    private int length;
    @Override
    public void overcomeLet(Abilities road) {
        if (road.checkRun()){
            System.out.println("Успешно пробежал");
        } else {
            System.out.println("Не смог пробежать");
        }
    }

    @Override
    public int lengthLet() {
        return length;
    }

    @Override
    public int highLet() {
        return 0;
    }
}
