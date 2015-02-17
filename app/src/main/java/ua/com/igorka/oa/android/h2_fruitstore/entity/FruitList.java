package ua.com.igorka.oa.android.h2_fruitstore.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class FruitList implements Parcelable {
    public static final int MIN_SIZE = 1;

    private String name;
    private IFruit[] list;
    private int[] amount;
    private int firstIndex = 0;
    private int lastIndex = 0; //free cell of array
    private int size;
    private int count = 0; //current number of items

    public FruitList(String name, int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Size should be " + MIN_SIZE + " or more");
        }
        this.size = size;
        this.name = name;
        list = new IFruit[size];
        amount = new int[size];
    }

    public FruitList() {
        this("New List", 10);
    }

    public void deleteAll() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
            amount[i] = 0;
        }
    }


    public void delete(IFruit o) {
        deleteItem(findDuplicateItem(o));
    }

    public void deleteFirst() {
        deleteItem(firstIndex);
    }

    public void deleteLast() {
        deleteItem(lastIndex);
    }

    private void deleteItem(int index) {
        list[index] = null;
        amount[index] = 0;
        count--;
        trimList(index);
    }

    private void trimList(int index) {
        if ((index == size - 1) || index == lastIndex - 1) {
            this.lastIndex--;
            return;
        }
        for (int i = index; i <= lastIndex - 1; i++) {
            list[i] = list[i + 1];
            amount[i] = amount[i + 1];
        }
        this.lastIndex--;
    }

    public void add(IFruit o, int amount) {
        if (isEmpty()) {
            addNewItem(o, amount);
            return;
        }
        int duplicateIndex = findDuplicateItem(o);
        if (duplicateIndex >= firstIndex) {
            addDuplicatedItem(o, amount, duplicateIndex);
            return;
        }
        addNewItem(o, amount);
    }

    private void addNewItem(IFruit o, int amount) {
        addItem(o, amount, lastIndex);
        lastIndex++;
        count++;
    }

    private void addDuplicatedItem(IFruit o, int amount, int index) {
        addItem(o, amount, index);
    }

    private void addItem(IFruit o, int amount, int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = o;
        this.amount[index] += amount;
    }

    //If there is a duplicated item in the list its index is returned
    private int findDuplicateItem(IFruit o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

    @Override
    public String toString() {
        return getString();
    }

    private String getString() {
        StringBuilder result = new StringBuilder();
        result.append("Name: " + name + "\n");
        for (int i = 0; i < lastIndex; i++) {
            result.append("Fruit: " + list[i].getName() + ", Price: "
                    + list[i].getPrice() + ", amount: " + amount[i] + "\n");
        }
        return result.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelableArray(list,0);
        dest.writeIntArray(amount);
        dest.writeInt(firstIndex);
        dest.writeInt(lastIndex);
        dest.writeInt(size);
        dest.writeInt(count);
    }

    private FruitList(Parcel in) {
        name = in.readString();
        Parcelable[] parcelableList = in.readParcelableArray(IFruit.class.getClassLoader());
        if (parcelableList != null) {
            list = Arrays.copyOf(parcelableList, parcelableList.length,IFruit[].class);
        }
        amount = in.createIntArray();
        firstIndex = in.readInt();
        lastIndex = in.readInt();
        size = in.readInt();
        count = in.readInt();

    }

    public static final Creator<FruitList> CREATOR = new Creator<FruitList>() {
        @Override
        public FruitList createFromParcel(Parcel source) {
            return new FruitList(source);
        }

        @Override
        public FruitList[] newArray(int size) {
            return new FruitList[size];
        }
    };


}
