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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Straight_to_labor_activity extends AppCompatActivity {

    private ViewGroup containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_straight_to_labor_activity);

        final FloatingActionButton tv = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.straight_to_labor_layout);

            }
        });


    }


    // clicki napeille, viedään putextraan haluttu synnytystapahtuma inttinä

    public void onClickListener_peratilan_synnytys(View view)
    {
        int tila = 2;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        startActivity(intent);
    }

    public void onClickListener_normaali_synnytys(View view)
    {
        int tila = 1;
        Intent intent = new Intent(this, SliderActivity.class);
        intent.putExtra("key",tila);
        startActivity(intent);
    }
}