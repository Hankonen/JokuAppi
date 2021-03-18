package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickListener_StraightToLabor(View view)
    {
        Toast.makeText(getApplicationContext(),"Suoraan synnytykseen",Toast.LENGTH_SHORT).show();
    }

    public void onClickListener_to_location(View view)
    {
        Toast.makeText(getApplicationContext(),"matkalla kohteesee",Toast.LENGTH_SHORT).show();
    }

    public void onClickListener_how_to_act(View view)
    {
        Toast.makeText(getApplicationContext(),"Kuinka Toimia",Toast.LENGTH_SHORT).show();
    }
    public void onClickListener_onTheWay_or_in_location(View view)
    {
        Toast.makeText(getApplicationContext(),"matkalle vai kohteessa",Toast.LENGTH_SHORT).show();
    }
}