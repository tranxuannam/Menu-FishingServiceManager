package com.fishing.namtran.fishingmanagerservice;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by nam.tran on 10/26/2017.
 */

public class BaseMenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.customer_manager:
                Toast.makeText(getApplicationContext(),
                        "Setting...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.report:
                Toast.makeText(getApplicationContext(),
                        "Up...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_customer:
                Toast.makeText(getApplicationContext(),
                        "Down...",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_other:
                Toast.makeText(getApplicationContext(),
                        "Other...",
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "Unknown...",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        //Return false to allow normal menu processing to proceed,
        //true to consume it here.
        //return false;
        return super.onOptionsItemSelected(item);
    }
}
