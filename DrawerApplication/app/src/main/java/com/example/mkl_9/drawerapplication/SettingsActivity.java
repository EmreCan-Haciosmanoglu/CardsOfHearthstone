package com.example.mkl_9.drawerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_help)
        {
          //  Intent intent = new Intent(SettingsActivity.this, HelpActivity.class);
           // startActivity(intent);
        }
        if (id == R.id.action_main)
        {
           // Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            //startActivity(intent);
        }
        if (id == R.id.action_recycler)
        {
           // Intent intent = new Intent(SettingsActivity.this, RecyclerActivity.class);
            //startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}