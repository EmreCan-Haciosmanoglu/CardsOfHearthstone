package cardsofhearthstone.cardsofhearthstone;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
}
