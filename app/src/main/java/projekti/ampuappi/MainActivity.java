package projekti.ampuappi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setSubtitle("joutsikako");
        toolbar.inflateMenu(R.menu.menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.first)
        {
            Toast.makeText(getApplicationContext(),"eka juttu",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.second)
        {
            Toast.makeText(getApplicationContext(),"Toka juttu",Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.third)
        {
            Toast.makeText(getApplicationContext(),"kolmas juttu",Toast.LENGTH_SHORT).show();
        }
        return true;

    }


    public void onClickListener_StraightToLabor(View view)
    {
      //  Toast.makeText(getApplicationContext(),"Suoraan synnytykseen",Toast.LENGTH_SHORT).show();

            final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);
            renameDialog.setTitle("Suoraan Synnytykseen");
            Context context = renameDialog.getContext();
            final LinearLayout layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            final TextView kohteessa = new EditText(context);
            kohteessa.setText("Hoidetaan kohteessa jos:\n •\tSupistuksia on 1-2 minuutin välein säännöllisesti\n •\tSynnyttäjällä on ponnistamisen pakko\n •\tSikiön pää näkyy");
            layout.addView(kohteessa);
            renameDialog.setView(layout);
            final Button Straight_to_labor = new Button(context);
            final ImageView kuva = new ImageView(context);
            kuva.setImageResource(R.drawable.ohje);
            layout.addView(kuva);

            renameDialog.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            renameDialog.show();
        };


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