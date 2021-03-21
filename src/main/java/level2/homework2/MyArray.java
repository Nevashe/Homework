package level2.homework2;


import level2.homework2.MyException.*;

import static level2.homework2.MyException.MyArrayDataException.getNumberArrayException;

public class MyArray {


    public static void main(String[] args) {
        String[][] strings =
                        {{"1", "1", "1", "a"},
                        {"1", "1", "1", "bb"},
                        {"1", "", "1", "1"},
                        {"asdas", "1", "-/ 12", "bb"}};
        try {
            inputArray(strings);

        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
    public static void inputArray(String[][] massive) throws MyArraySizeException {
        if (massive.length != 4 ||
                massive[0].length != 4 ||
                massive[1].length != 4 ||
                massive[2].length != 4 ||
                massive[3].length != 4) {
                    throw new MyArraySizeException("Массив должен быть 4х4");
                }
                int sum = 0;

                for (int i = 0; i < 4; i++) { //По идеи можно же сразу писать число а не длину массива? мы же уже проверили, верно?
                    for (int j = 0; j < 4; j++) {
                        try {
                            sum = sum + checkMyArrayDataException((massive[i][j]));
                        } catch (MyArrayDataException e) {
                            getNumberArrayException((massive[i][j]), i, j);
                        }
                    }
                }
        System.out.println("");
        System.out.println("Сумма элементов: " + sum );
    }
    private static int checkMyArrayDataException(String s) {
        try {
            int newS = Integer.parseInt(s);
            return newS;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке не число");
        }
    }
}
