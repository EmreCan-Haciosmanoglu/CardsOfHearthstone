package cardsofhearthstone.cardsofhearthstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent intent = new Intent(HelpActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_help)
        {
            Intent intent = new Intent(HelpActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_main)
        {
            Intent intent = new Intent(HelpActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_recycler)
        {
            Intent intent = new Intent(HelpActivity.this, RecyclerActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
