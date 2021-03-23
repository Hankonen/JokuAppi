package projekti.ampuappi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        Intent intent = new Intent(this, SliderActivity.class);

        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Suoraan synnytykseen", Toast.LENGTH_SHORT).show();
    }



    public void onClickListener_to_location(View view)
    {
        final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);
        renameDialog.setView(R.layout.alertbox_to_location_layout);
        renameDialog.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());

        renameDialog.show();

    }

    public void onClickListener_how_to_act(View view)
    {

        final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);
        renameDialog.setView(R.layout.alertbox_how_to_act_layout);
        renameDialog.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());

        renameDialog.show();


    };


    public void onClickListener_onTheWay_or_in_location(View view) {

        final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);
        renameDialog.setView(R.layout.alertbox_otw_or_il_layout);
        renameDialog.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());

        renameDialog.show();

         /* final ImageView kuva = new ImageView(context);        // Jätetty esimerkiksi tuleville hommille
            kuva.setImageResource(R.drawable.ohje);
            layout.addView(kuva);*/

     /*   // Toast.makeText(getApplicationContext(),"matkalle vai kohteessa",Toast.LENGTH_SHORT).show();
        final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);
        renameDialog.setTitle(getString(R.string.OTW_or_IL_HEADER));
        Context context = renameDialog.getContext();
        final LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        final TextView otw_or_il = new EditText(context);
        otw_or_il.setText(getString(R.string.OTW_or_IL_IL));
        layout.addView(otw_or_il);
        final TextView otw_or_il2 = new EditText(context);
        otw_or_il2.setText(getString(R.string.OTW_or_IL_OTW));
        layout.addView(otw_or_il2);
        renameDialog.setView(layout);

        renameDialog.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
        renameDialog.show(); */
    }

}