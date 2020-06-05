# Bin-Packing

### 201901694 이동빈



## #1. First Fit (최초 적합)

### 방법

첫 번째 bin부터 차례로 살펴보며, 가장 먼저 발견된 여유가 있는 bin에 item을 넣는다. 

```java
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

```



### 결과

![FirstFit](/assets/images/FirstFit.JPG)



---



## #2. Next Fit (다음 적합)

### 방법

직전에 작업한 bin에 여유가 있으면 item을 넣는다. 

```java
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
```



### 결과

![NextFit](/assets/images/NextFit.JPG)



---



## #3. Best Fit (최선 적합)

### 방법

기존 bin중 남는 부분이 가장 작은 bin에 item을 넣는다.

```java
import java.util.ArrayList;

public class BestFit implements Fit {
    @Override
    public void Fit(ArrayList<Bin> arr, Item item) {
        boolean flag = false; //기존의 bin에 담을 수 있는가?
        Bin bin = new Bin();
        for (int i = 0; i < arr.size(); i++) {
            Bin temp = arr.get(i);
            if (temp.check(item)) {
                flag = true; //담을 수 있다.
                //기존 bin중 remainCapacity가 가장 작은 bin에 item을 넣는다.
                if(bin.remainCapacity > temp.remainCapacity) bin = temp;
            }
        }
        bin.add(item);
        if(!flag) arr.add(bin); //그렇지 않으면 새로 bin 추가.
    }
}
```



### 결과

![BestFit](/assets/images/BestFit.JPG)



---



## #4. Worst Fit (최악 적합)

### 방법

기존의 bin 중 남는 부분이 가장 큰 bin 에 item을 넣는다.

```java
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
```



### 결과

![WorstFit](/assets/images/WorstFit.JPG)