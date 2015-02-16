package ua.com.igorka.oa.android.h2_fruitstore.entity;

import android.os.Parcel;

public class Apple extends Fruit {

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Apple> CREATOR = new Creator<Apple>() {
        @Override
        public Apple createFromParcel(Parcel source) {
            return new Apple(source);
        }

        @Override
        public Apple[] newArray(int size) {
            return new Apple[size];
        }
    };

    private Apple(Parcel source) {

    }

}
