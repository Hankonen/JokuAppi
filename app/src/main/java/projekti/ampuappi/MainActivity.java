package projekti.ampuappi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        setActionBar(toolbar);

    }


    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info_MenuItem:
                Intent intent_info = new Intent(MainActivity.this,info_Activity.class);
                startActivity(intent_info);

                return super.onOptionsItemSelected(item);

            case R.id.feedback_MenuItem:
                Intent intent_feedback = new Intent(MainActivity.this,feedback_Activity.class);
                startActivity(intent_feedback);

            default:
                    return super.onOptionsItemSelected(item); }
    }

    public void onClickListener_StraightToLabor(View view)
    {
        Intent intent = new Intent(this, Straight_to_labor_activity.class);
        startActivity(intent);

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
    }

}


   /* final ImageView kuva = new ImageView(context);                                                   // Jätetty esimerkiksi tuleville hommille
            kuva.setImageResource(R.drawable.ohje);
            layout.addView(kuva);*/
// Toast.makeText(getApplicationContext(), "Suoraan synnytykseen", Toast.LENGTH_SHORT).show();         // jätetty esimerkiksi

 /*final AlertDialog.Builder renameDialog = new AlertDialog.Builder(MainActivity.this);                 // Jätetty esimerkiksi talteen
        renameDialog.setView(R.layout.straight_to_labor_layout);
        renameDialog.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
        renameDialog.show();*/