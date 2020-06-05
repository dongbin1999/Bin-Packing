import java.util.ArrayList;

public class FirstFit implements Fit {
    @Override
    public void Fit(ArrayList<Bin> arr, Item item) {
        for (int i = 0; i < arr.size(); i++) {
            Bin bin = arr.get(i);
            if(bin.check(item)) {
                bin.add(item);
                return;
            }
        }

        //for문에서 return이 일어나지 않았다면, 기존의 bin에 item을 넣을 수 없음.
        Bin bin = new Bin();
        if(bin.check(item)) bin.add(item);
        arr.add(bin);
    }
}
