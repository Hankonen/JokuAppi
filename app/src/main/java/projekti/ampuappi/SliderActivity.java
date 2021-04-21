package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SliderActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout linearLayout;

    private TextView[] pageIndikaattori;
    private SliderAdapter sliderAdapter;

    private ImageButton leftButton;

    private ImageButton rightButton;
    private Button backbutton;

    private int currentPage;
    public int mikaSynnytysTapahtuma;

    public int sivujenMaara;

    Context context;

    private boolean isLastPageSwiped;
    private int counterPageScroll;

    private Straight_to_labor_activity straight_to_labor_activity;

    private int firstDiaLength, secondDiaLength, thirdDiaLength;
    private JSON json;
    private ArrayList<String> arrayListEkavaiheTitle, arrayListEkavaiheTeksti, arrayListPonnistusVaiheTitle, arrayListPonnistusVaiheTeksti, arrayListVikaVaiheTitle, arrayListVikaVaiheTeksti,
            arrayListPeratilaTitle, arrayListPeratilaTeksti, arrayListNapanuoraTitle, arrayListNapanuoraTeksti, arrayListHartiaTitle, arrayListHartiaTeksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        // Haetaan Straight to laborista tuodut tiedot eri esityksiin

        straight_to_labor_activity = new Straight_to_labor_activity();

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

        json = new JSON("pokemon");
        json.setKey("pokemon", getApplicationContext());

        arrayListEkavaiheTitle = json.get_json("first", "title");
        arrayListPonnistusVaiheTitle = json.get_json("second", "title");
        arrayListVikaVaiheTitle = json.get_json("third", "title");
        arrayListPeratilaTitle = json.get_json("fourth", "title");
        arrayListNapanuoraTitle = json.get_json("fifth", "title");
        arrayListHartiaTitle = json.get_json("sixsth", "title");

        firstDiaLength = arrayListEkavaiheTitle.size();
        Log.d("pituus", String.valueOf(firstDiaLength));

        secondDiaLength = arrayListPonnistusVaiheTitle.size();
        Log.d("pituus", String.valueOf(secondDiaLength));

        thirdDiaLength = arrayListVikaVaiheTitle.size();
        Log.d("pituus", String.valueOf(thirdDiaLength));



        slideViewPager.addOnPageChangeListener(viewListener);

        leftButton.setVisibility(View.GONE);
        leftButton.clearAnimation();
        Button next_phase = (Button)findViewById(R.id.button_next_phase);
        backbutton = (Button)findViewById(R.id.button_takaisin);

        if ( mikaSynnytysTapahtuma == 5)
        {
            rightButton.setVisibility(View.GONE);
            rightButton.clearAnimation();
            next_phase.setVisibility(View.VISIBLE);
            next_phase.setText("2. Diat");
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

        next_phase.clearAnimation();

    }

    public void addDotsIndikaattori(int pPosition)
    {
        pageIndikaattori = new TextView[sivujenMaara];
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


            if (position == sivujenMaara - 1 && positionOffset == 0 && !isLastPageSwiped){

                if(counterPageScroll != 0){
                    isLastPageSwiped=true;


                    // TODO ehtolauseet kaikille synnytystapahtumille missä ollaan ja mikä halutaan avattavan

                    if (mikaSynnytysTapahtuma == 5)
                    {
                        int synnytysTapahtuma = 1;
                        int diojenMaara = 4;
                        Intent intent = new Intent( getApplicationContext(), SliderActivity.class);
                        intent.putExtra("key", synnytysTapahtuma);
                        intent.putExtra("sivujenmaara", secondDiaLength);
                        startActivity(intent);
                        //finish();
                    }
                    if (mikaSynnytysTapahtuma == 1 || mikaSynnytysTapahtuma == 2 || mikaSynnytysTapahtuma == 3 || mikaSynnytysTapahtuma == 4)
                    {
                        int synnytysTapahtuma = 6;
                        int diojenMaara = 5;
                        Intent intent = new Intent(getApplicationContext(), SliderActivity.class);
                        intent.putExtra("key", synnytysTapahtuma);
                        intent.putExtra("sivujenmaara", thirdDiaLength);
                        startActivity(intent);
                        //finish();
                    }
                    if (mikaSynnytysTapahtuma == 6)
                    {
                        Intent intent = new Intent(getApplicationContext(), Straight_to_labor_activity.class);
                        startActivity(intent);
                        //finish();
                    }
                }

                counterPageScroll++;
            }
            else
            {
                counterPageScroll = 0;
            }
        }

        @Override
        public void onPageSelected(int position) {  // positio == sivu

            addDotsIndikaattori(position);
            currentPage = position;
            Button next_phase = (Button)findViewById(R.id.button_next_phase);

            if (position == 0)
            {
                backbutton.setText("Edelliseen diahan");
                rightButton.setEnabled(true);
                leftButton.setEnabled(false);
                leftButton.setVisibility(View.INVISIBLE);
                leftButton.clearAnimation();
            }
            else if (position == sivujenMaara - 1)
            {
                rightButton.setEnabled(false);
                leftButton.setEnabled(true);
                rightButton.setVisibility(View.INVISIBLE);

                next_phase.setText("3. diat");
                next_phase.setVisibility(View.VISIBLE);
                next_phase.setEnabled(true);

                if (mikaSynnytysTapahtuma == 6)
                {
                    next_phase.setText("Esitys päättyy");
                }
                // tähän shaibaa mitä haluat tapahtuvan vikalla dialla!!!
            }
            else
            {
                rightButton.setEnabled(true);
                leftButton.setEnabled(true);
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
        if (currentPage == 0)
        {
            finish();   // TODO back napin jälkeen swaippaus ei toimi kunnolla
        }
        else
        {
            Intent intent = new Intent(getApplicationContext(), Straight_to_labor_activity.class);
            startActivity(intent);
            finish();
        }
    }

    public void onClick_next_phase(View view)

    {
        if (mikaSynnytysTapahtuma == 5 )    // Jos synnytystapahtuma 5 eli ensimmäinen vaihe, niin mennään tilaan 1 eli toisen vaiheen normaalitilaan.
        {
            int tila = 1;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", secondDiaLength);
            startActivity(intent);
            //finish();
        }

        if (mikaSynnytysTapahtuma == 1 || mikaSynnytysTapahtuma == 2 || mikaSynnytysTapahtuma == 3 || mikaSynnytysTapahtuma == 4 )  // jos synnytystapahtuma on jokin toisen vaiheen tiloista niin siirrytään jälkeisvaiheeseen.
        {
            int tila = 6;
            int diojenMaara = 5;
            Intent intent = new Intent(this, SliderActivity.class);
            intent.putExtra("key",tila);
            intent.putExtra("sivujenmaara", thirdDiaLength);
            startActivity(intent);
            //finish();
        }
        if (mikaSynnytysTapahtuma == 6)     // jos ollaan jälkeisvaiheessa niin suljetaan activity ja siirrytään straight-to-laboriin
        {
            Intent intent = new Intent(getApplicationContext(), Straight_to_labor_activity.class);
            startActivity(intent);
            //finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

            finish();

            return true;
        }
        finish();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

}














