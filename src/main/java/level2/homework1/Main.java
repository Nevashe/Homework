package level2.homework1;

public class Main {
    public static void main(String[] args) {
        Cat bars = new Cat();

        Person person = new Person();
        Robot robot = new Robot();

        Road runRoad1 = new Road(5);
        Road runRoad2 = new Road(10);
        Road runRoad3 = new Road(15);

        Barrier barrier1 = new Barrier(1);
        Barrier barrier2 = new Barrier(2);
        Barrier barrier3 = new Barrier(3);

       // bars.run(runRoad);

        System.out.println(person.checkRun());
        Abilities[] abilitiesArr = {bars, person, robot};
        let[] letArr = {runRoad1, barrier1, runRoad2, barrier2, runRoad3, barrier3};

        for (Abilities arr1 : abilitiesArr){
            for (let arr2 : letArr) {
                //System.out.println(arr1.checkRun());
                arr2.overcomeLet(arr1);
            }
        }

        for (int arr1 = 0; arr1 < abilitiesArr.length; arr1++){
            int length = abilitiesArr[arr1].howCanRan();
            int jumps = abilitiesArr[arr1].howCanJump();
            for (let arr2 : letArr) {
                length = length - arr2.lengthLet();
                jumps = jumps - arr2.highLet();
            }
            if (length >= 0 && jumps >= 0) {
                System.out.println("Участник № " + (arr1 + 1) + " прошел полосу препятствий");
            } else {
                System.out.println("Участник № " + (arr1 + 1) + " не прошел полосу препятствий");
            }
        }

    }
}
