package cardsofhearthstone.cardsofhearthstone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class RecyclerActivity extends AppCompatActivity implements ListItemClickListener{

    public RecyclerView recyclerView;
    public GridLayoutManager gridLayoutManager;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        FetchCardsTask fetchCardsTask=new FetchCardsTask(this,recyclerView,this);
        fetchCardsTask.execute("");



        gridLayoutManager = new GridLayoutManager(this,2);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        /*recyclerView.setAdapter(adapter);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            Log.v("tagg","land");
            recyclerView.setLayoutManager(gridLayoutManager);

        }
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(layoutManager);
            Log.v("tagg","port");

        }*/


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent detailActivityIntent;

        String[] data = {"Detailed Card Info","default.jpg"};

        detailActivityIntent = new Intent(RecyclerActivity.this, DetailActivity.class);
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, data);

        startActivity(detailActivityIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent intent = new Intent(RecyclerActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_help)
        {
            Intent intent = new Intent(RecyclerActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_main)
        {
            Intent intent = new Intent(RecyclerActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_recycler)
        {
            Intent intent = new Intent(RecyclerActivity.this, RecyclerActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
