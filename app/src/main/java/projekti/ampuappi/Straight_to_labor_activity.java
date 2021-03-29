package projekti.ampuappi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Straight_to_labor_activity extends AppCompatActivity {

    private ViewGroup containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_straight_to_labor_activity);

       /* final ImageButton ib = (ImageButton) findViewById(R.id.imageButton_toka_vaihe_ED);

        final FloatingActionButton tv = (FloatingActionButton) findViewById(R.id.floatingAc);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.straight_to_labor_layout);

            }
        });*/
        final Button peratila = findViewById(R.id.button_peratilan_synnytys2);
        final Button hartiadystokia  = findViewById(R.id.button_hartiadystokia2);
        final Button napanuora  = findViewById(R.id.button_napanuoran_esiinluiskahdus2);
        final Button normaaliSynnytys  = findViewById(R.id.button_normal_labor2);
        final ImageButton first_phase = findViewById(R.id.imageButton_eka_vaihe_ED);
        final ImageButton second_phase = findViewById(R.id.imageButton_toka_vaihe_ED);
        final ImageButton third_phase = findViewById(R.id.imageButton_kolmas_vaihe_ED);


        second_phase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peratila.setVisibility(View.VISIBLE);
                hartiadystokia.setVisibility(View.VISIBLE);
                napanuora.setVisibility(View.VISIBLE);
                normaaliSynnytys.setVisibility(View.VISIBLE);
               //first_phase.
            }
        });

    }

    public void onClickListener_peratilan_synnytys(View view)
    {
        Intent intent = new Intent(this, SliderActivity.class);
        startActivity(intent);

    }

    public void onClick_exit (View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick_exit_2 (View view)
    {
        setContentView(R.layout.activity_straight_to_labor_activity);
    }





}