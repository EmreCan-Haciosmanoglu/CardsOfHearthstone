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

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,Datas.getData(),this);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        gridLayoutManager = new GridLayoutManager(this,2);
        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(adapter);
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            Log.v("tagg","land");
            recyclerView.setLayoutManager(gridLayoutManager);

        }
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(layoutManager);
            Log.v("tagg","port");

        }


    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent detailActivityIntent;

        String[] data = {"Detailed Card Info","default.jpg"};

        detailActivityIntent = new Intent(RecyclerActivity.this, DetailActivity.class);
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, data);

        startActivity(detailActivityIntent);
    }

}
