package projekti.ampuappi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
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

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);

        if (firstStart){
            showStartDialog();
        }
    }

    private void showStartDialog()
    {
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        new AlertDialog.Builder(this)
                .setTitle("Vastuuvapauslauseke")
                .setMessage("Tämä on vain ohjeeksi, emme ota vastuuta kaikista ohjeista")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.putBoolean("firstStart", false);
                        editor.apply();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("EN Hyväksy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.putBoolean("firstStart", true);
                        editor.apply();
                        finish();
                        System.exit(0);


                    }
                })
                .create().show();


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
        final AlertDialog.Builder tl = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toolbar_layout, null);



        tl.setCustomTitle(view);

        tl.setMessage(getString(R.string.to_location_HEADER));
        tl.setView(R.layout.alertbox_to_location_layout);
        tl.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
        tl.show();
    }

    public void onClickListener_how_to_act(View view)
    {
        final AlertDialog.Builder htw = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toolbar_layout, null);
        //view.setBackgroundColor(getResources().getColor(R.color.black));

        htw.setCustomTitle(view);
        htw.setMessage(getString(R.string.how_to_act_HEADER));
        htw.setView(R.layout.alertbox_how_to_act_layout);
        htw.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
        htw.show();
    };

    public void onClickListener_onTheWay_or_in_location(View view) {

        final AlertDialog.Builder otw = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.toolbar_layout, null);
        otw.setCustomTitle(view);
        otw.setMessage(getString(R.string.OTW_or_IL_HEADER));
        otw.setView(R.layout.alertbox_otw_or_il_layout);
        otw.setNegativeButton("Poistu", (dialog, which) -> dialog.cancel());
        otw.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {

            // Tehdään intentti jolla hypätään puhelimen valikkoon, System.exit(0) sulkee vain nykyisen activityn ja hyppää restartin kautta edelliseen activityyn.

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            View view;
            final AlertDialog.Builder otw = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.toolbar_layout, null);
            otw.setTitle("Lopetus");
            otw.setMessage("Haluatko varmasti lopettaa");

            otw.setNegativeButton("Poistu", (dialog, which) -> startActivity(intent));
            otw.setPositiveButton("Jatka", ((dialog, which) -> dialog.dismiss()));
            otw.show();

            return true;
        }

        return super.onKeyDown(keyCode, event);
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

 /*Intent intent_feedback_actions = new Intent(Intent.ACTION_SEND);                                        // jätetty malliksi
        intent_feedback_actions.setType("text/parse");
        intent_feedback_actions.putExtra(Intent.EXTRA_EMAIL, "feedback@ampuappi.com");
        intent_feedback_actions.putExtra(Intent.EXTRA_SUBJECT, "Palautetta sovellukseta");

        startActivity(Intent.createChooser(intent_feedback_actions, "Lähtä sähköposti"));*/