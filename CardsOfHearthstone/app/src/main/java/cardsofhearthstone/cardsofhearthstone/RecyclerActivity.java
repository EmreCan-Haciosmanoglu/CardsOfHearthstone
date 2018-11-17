package cardsofhearthstone.cardsofhearthstone;

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
import android.view.View;

public class RecyclerActivity extends AppCompatActivity implements ListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Something(null);
    }

    private void Something (Configuration newConfig)
    {
        setContentView(R.layout.activity_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(this,Datas.getData(),this);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        if(newConfig != null && newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        if(newConfig != null && newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            recyclerView.setLayoutManager(layoutManager);
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
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Something(newConfig);
    }
}
