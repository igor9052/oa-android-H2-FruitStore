 package ua.com.igorka.oa.android.h2_fruitstore.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ua.com.igorka.oa.android.h2_fruitstore.R;


 public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_new_list:
                Intent intent = new Intent(this, FruitListActivity.class);
                intent.setAction(FruitListActivity.ACTION_NEW_LIST);
                intent.putExtra(FruitListActivity.EXTRA_LIST_NAME, "My fruit list");
                intent.putExtra(FruitListActivity.EXTRA_LIST_LENGTH, 10);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
