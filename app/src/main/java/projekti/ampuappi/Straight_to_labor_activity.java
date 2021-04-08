package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

public class Straight_to_labor_activity extends AppCompatActivity {

    private ViewGroup containerView;
    public int tila;
    public int diojenMaara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_straight_to_labor_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        setActionBar(toolbar);

        final Button peratila = findViewById(R.id.button_peratilan_synnytys2);
        //final Button hartiadystokia  = findViewById(R.id.button_hartiadystokia2);
        final Button napanuora  = findViewById(R.id.button_napanuoran_esiinluiskahdus2);
        final Button normaaliSynnytys  = findViewById(R.id.button_normal_labor2);
        final Button first_phase = findViewById(R.id.button_eka_vaihe);
        //final Button second_phase = findViewById(R.id.button_toka_vaihe);
        //final Button third_phase = findViewById(R.id.button_erikoisvaiheet);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_MenuItem:
                Intent intent_info = new Intent(Straight_to_labor_activity.this,info_Activity.class);
                startActivity(intent_info);

                return super.onOptionsItemSelected(item);

            case R.id.feedback_MenuItem:
                Intent intent_feedback = new Intent(Straight_to_labor_activity.this,feedback_Activity.class);
                startActivity(intent_feedback);

            default:
                return super.onOptionsItemSelected(item); }
    }


    public void onClickListener_NormalLabor(View view) {

        tila = 1;
        diojenMaara = 4;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClickListener_peratilan_synnytys(View view)
    {
        int tila = 2;   // tilaa käytetään valitsemaan
        int diojenMaara = 3;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }


    public void onClickListener_hartiaDystokia(View view) {
        int tila = 3;
        int diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);

    }

    public void onClickListener_napanuoran_esiinluiskahdus(View view) {
        int tila = 4;
        int diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);

    }

    public void onClickListener_ekaVaihe(View view) {
        int tila = 5;
        int diojenMaara = 1;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);

        startActivity(intent);
    }

    public void onClickListener_kolmasVaihe(View view) {
        int tila = 6;
        int diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);

    }

    public void onClick_exit (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}