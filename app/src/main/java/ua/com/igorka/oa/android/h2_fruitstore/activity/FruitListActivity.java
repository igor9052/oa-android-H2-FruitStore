package ua.com.igorka.oa.android.h2_fruitstore.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ua.com.igorka.oa.android.h2_fruitstore.R;
import ua.com.igorka.oa.android.h2_fruitstore.entity.FruitFactory;
import ua.com.igorka.oa.android.h2_fruitstore.entity.FruitList;
import ua.com.igorka.oa.android.h2_fruitstore.entity.IFruit;

public class FruitListActivity extends ActionBarActivity {

    public static final String FRUIT_LIST = "FRUIT_LIST";
    private FruitList fruitList = null;

    public static final String ACTION_NEW_LIST = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_NEW_LIST";
    public static final String ACTION_PRINT = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_PRINT";
    public static final String ACTION_ADD = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_ADD";
    public static final String ACTION_DELETE_LIST = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_DELETE_LIST";
    public static final String ACTION_DELETE_FIRST = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_DELETE_FIRST";
    public static final String ACTION_DELETE_LAST = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_DELETE_LAST";
    public static final String ACTION_DELETE = "ua.com.igorka.oa.android.h2_fruitstore.ACTION_DELETE";

    //Extras
    public static final String LIST_LENGTH = "LIST_LENGTH";
    public static final String LIST_NAME = "LIST_NAME";
    public static final String FRUIT_NAME = "FRUIT_NAME";
    public static final String FRUIT_AMOUNT = "FRUIT_AMOUNT";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(FRUIT_LIST, fruitList);
        Log.i("SAVE_LIST: ", fruitList.toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fruitList = savedInstanceState.getParcelable(FRUIT_LIST);
        Log.i("RESTORE_LIST: ", fruitList.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("ON_CREATE", getIntent().getAction());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);
        fruitList = new FruitList();
        Intent intent = getIntent();
        if (ACTION_NEW_LIST.equals(intent.getAction())) {
            fruitList = new FruitList(intent.getStringExtra(LIST_NAME), intent.getIntExtra(LIST_LENGTH, 0));
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("INTENT", "ON_NEW_INTENT");
        if (intent == getIntent()) {
            setIntent(new Intent().setAction("NONE"));
            Log.i("INTENT", "The same intent");
        }
        setIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ON_START", getIntent().getAction());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ON_RESUME", getIntent().getAction());
        Intent intent = getIntent();
        switch (intent.getAction()) {
            case ACTION_PRINT:
                TextView textView = (TextView) findViewById(R.id.text);
                if (fruitList != null) {
                    textView.setText(fruitList.toString());
                }
                break;
            case ACTION_NEW_LIST:
                fruitList = new FruitList(intent.getStringExtra(LIST_NAME), intent.getIntExtra(LIST_LENGTH, 0));
                break;
            case ACTION_ADD:
                IFruit newFruit = FruitFactory.makeFruit(intent.getStringExtra(FRUIT_NAME));
                fruitList.add(newFruit, intent.getIntExtra(FRUIT_AMOUNT, 1));
                Log.i("LIST: ", fruitList.toString());
                break;
            case ACTION_DELETE_LIST:
                fruitList.deleteAll();
                break;
            case ACTION_DELETE_FIRST:
                fruitList.deleteFirst();
                break;
            case ACTION_DELETE_LAST:
                fruitList.deleteLast();
                break;
            case ACTION_DELETE:
                IFruit delFruit = FruitFactory.makeFruit(intent.getStringExtra(FRUIT_NAME));
                fruitList.delete(delFruit);
                break;
        }
        setIntent(new Intent().setAction("NONE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ON_PAUSE", getIntent().getAction());
        setIntent(new Intent().setAction("NONE"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("ON_STOP", getIntent().getAction());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("ON_DESTROY", getIntent().getAction());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fruit_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
