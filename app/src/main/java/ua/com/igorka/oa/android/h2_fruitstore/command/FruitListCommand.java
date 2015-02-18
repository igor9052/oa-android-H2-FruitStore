package ua.com.igorka.oa.android.h2_fruitstore.command;

import android.app.Activity;
import android.content.Intent;

import ua.com.igorka.oa.android.h2_fruitstore.activity.FruitListActivity;

public interface FruitListCommand {

    static final Class<FruitListActivity> FRUIT_LIST_ACTIVITY_CLASS = FruitListActivity.class;

    void execute(Activity activity);
}
