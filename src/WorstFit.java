import java.util.ArrayList;

public class WorstFit implements Fit {
    @Override
    public void Fit(ArrayList<Bin> arr, Item item) {
        boolean flag = false; //기존의 bin에 담을 수 있는가?
        Bin bin = new Bin();
        for (int i = 0; i < arr.size(); i++) {
            Bin temp = arr.get(i);
            if (temp.check(item)) {
                if(!flag) bin = temp;
                flag = true; //담을 수 있다.
                //기존 bin중 remainCapacity가 가장 큰 bin에 item을 넣는다.
                if(bin.remainCapacity < temp.remainCapacity) bin = temp;
            }
        }
        bin.add(item);
        if(!flag) arr.add(bin); //그렇지 않으면 새로 bin 추가.
    }
}
