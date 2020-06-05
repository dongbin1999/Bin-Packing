import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] items = new int[] {7, 5, 6, 4, 2, 3, 7, 5};
        ArrayList<Bin> arr = new ArrayList<>();

        Fit f = new NextFit();
        for (int i = 0; i < items.length; i++) {
            f.Fit(arr, new Item(items[i]));
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        System.out.println(arr.size());
    }
}
