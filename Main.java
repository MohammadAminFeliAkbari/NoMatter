import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] str;
        HeapCustom heap;

        try (Scanner scanner = new Scanner(System.in)) {
            str = scanner.nextLine().split(" ");

            heap = new HeapCustom(str.length);

            for (int i = 0; i < str.length; i++)
                heap.insert(Integer.parseInt(str[i]));
        }

        while (heap.size() != 1) {
            int one = heap.remove();
            int two = heap.remove();
            heap.insert(Math.abs(one - two));
        }

        while (heap.size() != 0) {
            System.out.println(heap.remove());
        }
    }
}
