package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SliderActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout linearLayout;

    private TextView[] pageIndikaattori;
    private SliderAdapter sliderAdapter;

    private ImageButton leftButton;
    private ImageButton rightButton;
    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        Toast.makeText(getApplicationContext(), "Suoraan synnytykseen", Toast.LENGTH_SHORT).show();

        Intent i = getIntent();
        int arvo = i.getIntExtra("key", 1);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        leftButton = (ImageButton)findViewById(R.id.id_iButton_Left);
        rightButton = findViewById(R.id.id_iButton_Right);

        sliderAdapter = new SliderAdapter(this, arvo);

        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndikaattori(0);

        slideViewPager.addOnPageChangeListener(viewListener);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage - 1);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(currentPage + 1);
            }
        });

    }

    public void addDotsIndikaattori(int pPosition)
    {
        pageIndikaattori = new TextView[5];
        linearLayout.removeAllViews();

        for (int i = 0; i < pageIndikaattori.length; i++)
        {
            pageIndikaattori[i] = new TextView(this);
            pageIndikaattori[i].setText(Html.fromHtml("&#8226;"));  //tekee ympyrät
            pageIndikaattori[i].setTextSize(35);
            pageIndikaattori[i].setTextColor(getResources().getColor(R.color.white_dots_color));

            linearLayout.addView(pageIndikaattori[i]);
        }

        if (pageIndikaattori.length > 0)
        {
            pageIndikaattori[pPosition].setTextColor(getResources().getColor(R.color.black));
        }
    }

    // tarkistetaan millä sivulla ollaan

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {  // positio == sivu

            addDotsIndikaattori(position);
            currentPage = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}