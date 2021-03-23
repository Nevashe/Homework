package level2.homework3;

public class EightSymbolException extends Exception{

    public EightSymbolException() {
        System.out.println("В телефоне должно быть 11 цифр, начиная с 8");
    }
}
