public class Bin {
    public int capacity = 10;
    public int currentCapacity = 0;
    public int remainCapacity = 10;

    public boolean check(Item item) {
        if(remainCapacity >= item.size) return true;
        else return false;
    }

    public void add(Item item) {
        currentCapacity += item.size;
        remainCapacity = capacity - currentCapacity;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "capacity=" + capacity +
                ", currentCapacity=" + currentCapacity +
                ", remainCapacity=" + remainCapacity +
                '}';
    }
}
