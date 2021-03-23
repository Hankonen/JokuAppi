package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SliderActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        slideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }
}