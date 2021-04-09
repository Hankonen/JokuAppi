package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout linearLayout;

    private TextView[] pageIndikaattori;
    private SliderAdapter sliderAdapter;

    private ImageButton leftButton;


    private ImageButton rightButton;
    private int currentPage;
    public int mikaSynnytysTapahtuma;

    public int sivujenMaara;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        // Haetaan Straight to laborista tuodut tiedot eri esityksiin

        Intent i = getIntent();
        mikaSynnytysTapahtuma = i.getIntExtra("key", 1);
        sivujenMaara = i.getIntExtra("sivujenmaara", 1);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        leftButton = (ImageButton)findViewById(R.id.id_iButton_Left);
        rightButton = findViewById(R.id.id_iButton_Right);

        sliderAdapter = new SliderAdapter(this, mikaSynnytysTapahtuma, sivujenMaara);    // heitetään parametreiksi tänne jotta SliderAdapter class tietää mitkä kuvat näytetään

        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndikaattori(0);

        slideViewPager.addOnPageChangeListener(viewListener);

        leftButton.setVisibility(View.GONE);
        leftButton.clearAnimation();
        Button next_phase = (Button)findViewById(R.id.button_next_phase);
        if ( mikaSynnytysTapahtuma == 5)
        {
            rightButton.setVisibility(View.GONE);
            rightButton.clearAnimation();
            next_phase.setVisibility(View.VISIBLE);
            next_phase.setText("Vaihe 2");
            next_phase.clearAnimation();

        }



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

        for (int i = 0; i < sivujenMaara; i++)
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
        private volatile boolean jep;


        @Override
        public void onPageSelected(int position) {  // positio == sivu

            addDotsIndikaattori(position);
            currentPage = position;
            Button next_phase = (Button)findViewById(R.id.button_next_phase);




            if (position == 0)
            {
                rightButton.setEnabled(jep =true);
                leftButton.setEnabled(jep = false);
                leftButton.setVisibility(View.INVISIBLE);
                leftButton.clearAnimation();
            }
            else if (position == sivujenMaara - 1)
            {
                rightButton.setEnabled(jep=false);
                leftButton.setEnabled(jep=true);
                rightButton.setVisibility(View.INVISIBLE);

                next_phase.setText("3 Vaihe");
                next_phase.setVisibility(View.VISIBLE);
                next_phase.setEnabled(jep = true);

                if (mikaSynnytysTapahtuma == 6)
                {
                    next_phase.setText("Esitys päättyy");
                }
                // tähän shaibaa mitä haluat tapahtuvan vikalla dialla!!!
            }
            else
            {
                rightButton.setEnabled( jep = true);
                leftButton.setEnabled( jep = true);
                leftButton.setVisibility(View.VISIBLE);
                rightButton.setVisibility(View.VISIBLE);
                next_phase.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void onClickListener_back_button(View view)
    {
        Intent intent = new Intent(this, Straight_to_labor_activity.class);
        startActivity(intent);
    }

    public void onClick_next_phase(View view)

    {
        if (mikaSynnytysTapahtuma == 5 )
        {
            int tila = 1;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", diojenMaara);
            startActivity(intent);
        }

        if (mikaSynnytysTapahtuma == 1 || mikaSynnytysTapahtuma == 2 || mikaSynnytysTapahtuma == 3 || mikaSynnytysTapahtuma == 4 )

        {
            int tila = 6;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", diojenMaara);
            startActivity(intent);
        }
        if (mikaSynnytysTapahtuma == 6)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}














