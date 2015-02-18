package ua.com.igorka.oa.android.h2_fruitstore.command.impl.FruitListActivityCommand;

import android.app.Activity;
import android.content.Intent;
import ua.com.igorka.oa.android.h2_fruitstore.activity.FruitListActivity;
import ua.com.igorka.oa.android.h2_fruitstore.command.FruitListCommand;

public class AddCommand implements FruitListCommand {
    @Override
    public void execute(Activity activity) {
        Intent intent = new Intent(activity, FRUIT_LIST_ACTIVITY_CLASS);
        intent.setAction(FruitListActivity.ACTION_ADD);
        intent.putExtra(FruitListActivity.EXTRA_FRUIT_NAME, "Apple");
        intent.putExtra(FruitListActivity.EXTRA_FRUIT_AMOUNT, 10);
        activity.startActivity(intent);
    }

}
