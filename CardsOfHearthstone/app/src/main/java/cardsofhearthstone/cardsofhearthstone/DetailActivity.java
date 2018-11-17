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
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView mDetailInfoView;
    private ImageView mDetailImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intentThatStartedThisActivity;
        String[]   forecastStr;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDetailInfoView     = (TextView) findViewById(R.id.tv_detail);
        mDetailImageView    = (ImageView) findViewById(R.id.iv_detail);
        intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){

            forecastStr = intentThatStartedThisActivity.getStringArrayExtra(Intent.EXTRA_TEXT);

            mDetailInfoView.setText(forecastStr[0]);
            if(forecastStr[1].equals("default.jpg"))
            {
                mDetailImageView.setImageResource(R.drawable.ic_launcher_background);
            }
        }
        else{
            mDetailInfoView.setText("NO CARD DATA");
        }
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
            Intent intent = new Intent(DetailActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_help)
        {
            Intent intent = new Intent(DetailActivity.this, HelpActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_main)
        {
            Intent intent = new Intent(DetailActivity.this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.action_recycler)
        {
            Intent intent = new Intent(DetailActivity.this, RecyclerActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
