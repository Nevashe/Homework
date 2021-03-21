package level2.homework2.MyException;

public class MyArrayDataException extends NumberFormatException{


    public MyArrayDataException(String message) {
        super(message);
    }
      public static void getNumberArrayException(String s, int i, int j){
          System.out.println("В ячейку [" + i + "][" + j + "] введены некорректные данные \"" + s + "\"");
      }
}
