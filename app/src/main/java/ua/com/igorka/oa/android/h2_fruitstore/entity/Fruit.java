package ua.com.igorka.oa.android.h2_fruitstore.entity;

import android.os.Parcel;
import android.os.Parcelable;


public abstract class Fruit implements IFruit {

    private String name;
    private int price;

    protected Fruit() {
        this("unknown", 0);
    }

    protected Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeInt(getPrice());
    }

    protected Fruit(Parcel in) {
        setName(in.readString());
        setPrice(in.readInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit)) return false;

        if (!this.getClass().getName().equals(o.getClass().getName())) {
            return  false;
        }

        Fruit fruit = (Fruit) o;

        if (price != fruit.price) return false;
        if (name != null ? !name.equals(fruit.name) : fruit.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
