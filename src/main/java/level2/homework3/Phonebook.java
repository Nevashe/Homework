package level2.homework3;

import level2.homework2.MyException.MyArrayDataException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) {

        add("888aa", "Петров");
        add("88005553515", "Петров");
        add("88003334434", "Петров");
        add("88002000122", "Иванов");
        add("84959895050", "Сидоров");
        add("88883", "Иванов");
        add("88884", "Сидоров");
        setDirectory();
        System.out.println();
        get("Петров");

    }

    private static Map<String, String> directory = new HashMap<>();

    public static void add(String phone, String lastName) {
        try {

            checkPhone(phone);
            directory.put(phone, lastName);
        } catch (NumberFormatException e) {
            System.out.println("Телефон должен быть введен только цифрами");
        } catch (EightSymbolException e){

        }
    }

    public static void get(String lastName) {
        Iterator<String> iterator = directory.keySet().iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (directory.get(str).equals(lastName)) {
                System.out.println("Phone: " + str + "  Lastname: " + directory.get(str));
            }
        }
    }

    private static void setDirectory() {
        Iterator<String> iterator = directory.keySet().iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println("Phone: " + str + "  Lastname: " + directory.get(str));
        }
    }
    // из задания я понял что ничего своего добавлять не надо
    // но мне показалось это логичным условием
    private static void checkPhone(String phone) throws EightSymbolException {
        String str1 = phone.substring(0, phone.length()/2); // int не вмещает в себя столько цифр сколько в телефоне, пришлось разбить
        String str2 = phone.substring(phone.length()/2, phone.length()); // по идеи могут ввести еще больше цифр, можно написать цикл, но я уже не стал

        int tmp1 = Integer.parseInt(str1);
        int tmp2 = Integer.parseInt(str2);
        if (!(phone.length() == 11)){
            throw new EightSymbolException();
        }

    }
}
