package ua.com.igorka.oa.android.h2_fruitstore.entity;

public class FruitList {

    public static final int MIN_SIZE = 1;
    private IFruit[] list;
    private int[] amount;
    private int firstIndex = 0;
    private int currentIndex = 0;
    private int size;
    private int count = 0;

    public FruitList(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Size should be " + MIN_SIZE + " or more");
        }
        this.size = size;
        list = new IFruit[size];
        amount = new int[size];
    }

    public void add(IFruit o, int amount) {
        if (isEmpty()) {
            addItem(o, amount);
            return;
        }
        int dublicateIndex = findDuplicate(o);
    }

    private int findDuplicate(IFruit o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(list[1])) {
                return i;
            }
        }
        return -1;
    }


    private void addItem(IFruit o, int amount) {
        if (currentIndex >= size) {
            throw new IndexOutOfBoundsException();
        }
        list[currentIndex].setName(o.getName());
        list[currentIndex].setPrice(o.getPrice());
        this.amount[currentIndex] += amount;
        currentIndex++;
        count++;
    }



    private boolean isEmpty() {
        return this.count == 0 ? true : false;
    }
}
