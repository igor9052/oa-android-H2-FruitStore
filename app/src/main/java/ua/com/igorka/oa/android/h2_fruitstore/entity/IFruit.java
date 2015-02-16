package ua.com.igorka.oa.android.h2_fruitstore.entity;

import android.os.Parcelable;

public interface IFruit extends Parcelable{
    String getName();
    void setName(String name);
    int getPrice();
    void setPrice(int price);
}
