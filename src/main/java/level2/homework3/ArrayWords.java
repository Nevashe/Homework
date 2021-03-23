package level2.homework3;

import java.util.*;


public class ArrayWords {

    public static void main(String[] args) {
        method1();
    }
    public static void method1(){
        String[] arrayString = {"Один", "Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Восемь", "Семь", "Шесть", "Пять", "Четыре",
                "Три", "Два", "Один", "Ноль", "Восемдесят четыре"};
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, arrayString);
        System.out.println(arrayList);
        Map<String, Integer> duplicateWords = new HashMap<>();

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();

            if (duplicateWords.get(str) == null){
                duplicateWords.put(str, 1);
            } else {
                duplicateWords.put(str, duplicateWords.get(str) + 1);
            }
            //  условие if/else предложил заменить на строку ниже, менять не стал, оставил авторский код:)
            //     duplicateWords.merge(str, 1, Integer::sum);
        }
        System.out.println(duplicateWords);
    }
}
