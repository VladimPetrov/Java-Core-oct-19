package lesson10;

import java.sql.SQLOutput;
import java.util.*;
import java.util.function.UnaryOperator;

public class ClassRoom {
    public static void main (String[] args) {

        Byte b=10;
        byte b1=11;
        //setExample();
        Map<String, Integer> map = new HashMap<>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        //map.put("A",4);
        map.putIfAbsent("A", 4);
        map.forEach((k,v) -> System.out.println(k + ":" + v));
        for (Integer values : map.values()) {
            System.out.println(values);
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }



        System.out.println(map.get("C"));
        System.out.println(map.get("W"));
        System.out.println(map.getOrDefault("W", 99));
        System.out.println(map);
    }

    private static void setExample() {
        Set<String> set = new HashSet<>();
        set.add("Январь");
        set.add("Февраль");
        set.add(null);
        set.add(null);
        set.add("Март");
        set.add("Февраль");
        set.add(null);
        System.out.println(set);
        for (String s : set) {
            System.out.println(s);
        }
        set.forEach(s -> System.out.println(s));
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void listsExample() {
    //        List<String> list = new ArrayList<>();
    List<String> list = new LinkedList<>();
//        List<String> list = new Vector<>();
    list.add("Январь");
    list.add("Февраль");
    list.add(null);
    list.add(null);
    list.add("Март");
    list.add("Февраль");
    list.add(null);

    list.add(2,"Апрель");
    list.addAll(Arrays.asList("Май","Июнь"));
    list.remove(3);
    list.remove("Февраль");
    list.set(2,"Сентябрь");
    //list.sort("");
    System.out.println(list.get(5));
    list.replaceAll(new UnaryOperator<String>() {
        @Override
        public String apply(String s) {
            return s + " month";
        }
    });

    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }

    for (String s : list) {
        System.out.println(s);
    }

    Iterator iter = list.iterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }

    ListIterator iter1 = list.listIterator();
    while (iter1.hasNext()) {
        iter1.next();
        iter1.set("SSSS");
    }

    list.forEach(System.out::println);



    System.out.println(list);

    }
}
