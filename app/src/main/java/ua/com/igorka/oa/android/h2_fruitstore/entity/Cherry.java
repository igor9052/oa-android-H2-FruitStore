package ua.com.igorka.oa.android.h2_fruitstore.entity;

import android.os.Parcel;

public class Cherry extends Fruit {

    public Cherry(String name, int price) {
        super(name, price);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Cherry> CREATOR = new Creator<Cherry>() {
        @Override
        public Cherry createFromParcel(Parcel source) {
            return new Cherry(source);
        }

        @Override
        public Cherry[] newArray(int size) {
            return new Cherry[size];
        }
    };

    private Cherry(Parcel in) {

    }

}
