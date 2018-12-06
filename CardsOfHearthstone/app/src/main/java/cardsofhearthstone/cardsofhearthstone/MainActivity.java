package cardsofhearthstone.cardsofhearthstone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String[] aray=new String[5];
        con = this;
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button1=(Button)findViewById(R.id.startButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecyclerActivity.class);
                FetchCardsTask fetchCardsTask=new FetchCardsTask(con);
                fetchCardsTask.execute("https://api.hearthstonejson.com/v1/25770/enUS/cards.collectible.json");
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.helpButton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HelpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_help)
        {
            Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_main)
        {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_recycler)
        {
            Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
            startActivity(intent);
        }
        if ( id == R.id.action_refresh)
        {
            FetchCardsTask m_Task = new FetchCardsTask(con);
            m_Task.execute();
        }

        return super.onOptionsItemSelected(item);
    }
}
