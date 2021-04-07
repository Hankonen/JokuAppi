package projekti.ampuappi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
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
    public int arvo;

    public int sivujenMaara;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        Intent i = getIntent();
        arvo  = i.getIntExtra("key", 1);
        sivujenMaara = i.getIntExtra("sivujenmaara", 1);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        leftButton = (ImageButton)findViewById(R.id.id_iButton_Left);
        rightButton = findViewById(R.id.id_iButton_Right);

        sliderAdapter = new SliderAdapter(this, arvo, sivujenMaara);

        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndikaattori(0);

        slideViewPager.addOnPageChangeListener(viewListener);

        leftButton.setVisibility(View.GONE);
        leftButton.clearAnimation();
        Button next_phase = (Button)findViewById(R.id.button_next_phase);
        if ( arvo == 5)
        {
            rightButton.setVisibility(View.GONE);
            rightButton.clearAnimation();
            Toast.makeText(SliderActivity.this, "Häpyykö", Toast.LENGTH_SHORT).show();
            next_phase.setVisibility(View.VISIBLE);
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

            next_phase.setText("Seuraava vaihe");


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
                Toast.makeText(SliderActivity.this, "Viimeinen dia", Toast.LENGTH_SHORT).show();

                next_phase.setVisibility(View.VISIBLE);
                next_phase.setEnabled(jep = true);

                // tähän shaibaa mitä haluat tapahtuvan vikalla dialla!!!
            }
            else
            {
                rightButton.setEnabled( jep =true);
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
        if (arvo == 5 )
        {
            int tila = 1;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", diojenMaara);
            startActivity(intent);
        }

        if (arvo == 2 || arvo == 3 || arvo == 4 )

        {
            int tila = 6;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", diojenMaara);
            startActivity(intent);
        }
        if (arvo == 6)
        {
            final AlertDialog.Builder otw = new AlertDialog.Builder(SliderActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.toolbar_layout, null);
            otw.setCustomTitle(view);
            otw.setMessage(getString(R.string.OTW_or_IL_HEADER));
            otw.setView(R.layout.alertbox_otw_or_il_layout);
            otw.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
            otw.show();
        }

    }
}














