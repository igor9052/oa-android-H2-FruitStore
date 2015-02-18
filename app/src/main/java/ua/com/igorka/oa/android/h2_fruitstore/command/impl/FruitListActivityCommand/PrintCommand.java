package ua.com.igorka.oa.android.h2_fruitstore.command.impl.FruitListActivityCommand;

import android.app.Activity;
import android.content.Intent;

import ua.com.igorka.oa.android.h2_fruitstore.activity.FruitListActivity;
import ua.com.igorka.oa.android.h2_fruitstore.command.FruitListCommand;

/**
 * Created by igor9_000 on 18.02.2015.
 */
public class PrintCommand implements FruitListCommand {
    @Override
    public void execute(Activity activity) {
        Intent intent = new Intent(activity, FRUIT_LIST_ACTIVITY_CLASS);
        intent.setAction(FruitListActivity.ACTION_PRINT);
        activity.startActivity(intent);
    }
}
