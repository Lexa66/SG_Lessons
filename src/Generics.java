import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40, 50};
        String[] mas = {"z", "c","a","b"};
        exchange(arr);
        System.out.println();
        max(mas);
        convert(arr);
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        toArray(list);

    }

    public static <T> void exchange(T[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
                T c = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = c;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static <T extends Comparable> void max(T[] obj) {
        Arrays.sort(obj);
        for (int i = 0; i < obj.length; i++) {
            System.out.print(obj[i] + " ");
        }
    }

    public static <T> void convert(T[] arr) {
        List<T> list = Arrays.asList(arr);
        System.out.print(list + " ");
        System.out.println();
    }
    public static <T> void toArray(List <T> arr) {
        T[] mas = (T[]) arr.toArray();
        System.out.println(Arrays.toString(mas));
        System.out.println();
    }
}
