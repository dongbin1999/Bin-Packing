import java.util.ArrayList;

public class NextFit implements Fit {
    @Override
    public void Fit(ArrayList<Bin> arr, Item item) {
        boolean create = false; //새로운 bin을 생성해야 하는가?
        Bin bin;
        if(arr.isEmpty()) { //원래 bin이 없었다면,
            create = true; //생성해야한다.
            bin = new Bin();
        }
        else bin = arr.get(arr.size() - 1); //직전에 확인한 bin을 본다.

        if(!bin.check(item)) { //그 bin에 넣을 수 없다면,
            create = true; //생성해야한다.
            bin = new Bin();
        }
        bin.add(item);
        if(create) arr.add(bin); //새로운 bin을 생성했다면, arr에 추가.
    }
}
