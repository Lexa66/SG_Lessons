import java.util.*;

public class Maps {
    public static void main(String[] args) {
        HashMap<String, String> dataMap = data();
        int name = getSameName(dataMap, "Paolo");
        int surname = getSameSurname(dataMap, "Cannavaro");
        System.out.println("Task № 1");
        System.out.println("Same names - " + name);
        System.out.println("Same surname - " + surname);
        System.out.println();

        System.out.println("Task № 2");
        HashMap<String, GregorianCalendar> map = data2();
        remove(map);
        for (Map.Entry<String, GregorianCalendar> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }

    //Task № 1

    public static HashMap<String, String> data() {

        HashMap<String, String> map = new HashMap<>();
        map.put("Del Piero", "Alessandro");
        map.put("Maldini", "Paolo");
        map.put("Nesta", "Alessandro");
        map.put("Vieri", "Christian");
        map.put("Cannavaro", "Fabio");
        map.put("Rossi", "Paolo");
        map.put("Totti", "Francesko");
        map.put("Inzaghi", "Fillipo");
        map.put("Di Vaio", "Marco");
        map.put("Toni", "Luca");

        return map;
    }

    public static int getSameSurname(HashMap<String, String> map, String surname) {
        int l = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(surname)) l++;
        }
        return l;
    }

    public static int getSameName(HashMap<String, String> map, String name) {
        int n = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name))
                n++;
        }
        return n;
    }

    //Task № 2

    public static HashMap<String, GregorianCalendar> data2() {

        HashMap<String, GregorianCalendar> map = new HashMap<>();

        map.put("Del Piero", new GregorianCalendar(1974, 11, 14));
        map.put("Maldini", new GregorianCalendar(1968, 1, 24));
        map.put("Nesta", new GregorianCalendar(1972, 6, 31));
        map.put("Vieri", new GregorianCalendar(1970, 0, 30));
        map.put("Cannavaro", new GregorianCalendar(1980, 0, 22));
        map.put("Rossi", new GregorianCalendar(1985, 7, 12));
        map.put("Totti", new GregorianCalendar(1984, 2, 21));
        map.put("Inzaghi", new GregorianCalendar(1983, 8, 15));
        map.put("Di Vaio", new GregorianCalendar(1981, 0, 17));
        map.put("Toni", new GregorianCalendar(1977, 6, 18));

        return map;
    }

    public static void remove(HashMap<String, GregorianCalendar> map) {
        for (Iterator<Map.Entry<String, GregorianCalendar>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {

            Map.Entry<String, GregorianCalendar> pair = iterator.next();

            if (pair.getValue().get(Calendar.MONTH) >= 5 && pair.getValue().get(Calendar.MONTH) <= 7) {
                iterator.remove();
            }
        }
    }
}