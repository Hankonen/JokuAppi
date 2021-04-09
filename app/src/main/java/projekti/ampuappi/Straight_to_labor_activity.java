package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

public class Straight_to_labor_activity extends AppCompatActivity {

    private ViewGroup containerView;
    public int synnytysTapahtuma;
    public int diojenMaara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_straight_to_labor_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setSubtitle(R.string.button_straight_to_labor);
        toolbar.inflateMenu(R.menu.menu);
        setActionBar(toolbar);
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

    // viedään putextrana tieto mikä synnytystapahtuma valittu karttanäkymässä, lisäksi viedään tieto montako "diaa" tapahtumassa on

    public void onClickListener_NormalLabor(View view)
    {
        synnytysTapahtuma = 1;
        diojenMaara = 4;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClickListener_peratilan_synnytys(View view)
    {
        synnytysTapahtuma = 2;   // tilaa käytetään valitsemaan
        diojenMaara = 3;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }


    public void onClickListener_hartiaDystokia(View view) {
        synnytysTapahtuma = 3;
        diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClickListener_napanuoran_esiinluiskahdus(View view) {
        synnytysTapahtuma = 4;
        diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClickListener_ekaVaihe(View view) {
        synnytysTapahtuma = 5;
        diojenMaara = 1;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClickListener_kolmasVaihe(View view) {
        synnytysTapahtuma = 6;
        diojenMaara = 5;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key", synnytysTapahtuma);
        intent.putExtra("sivujenmaara", diojenMaara);
        startActivity(intent);
    }

    public void onClick_exit (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}