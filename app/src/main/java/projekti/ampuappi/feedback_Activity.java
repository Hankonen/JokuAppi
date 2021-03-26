package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class feedback_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_);
    }

    public void onClickListener_feedback(View view)
    {
        EditText feedback = findViewById(R.id.editText_feedback);
        String feed= feedback.toString();

        Intent intent_feedback_actions = new Intent(Intent.ACTION_SEND);
        intent_feedback_actions.setType("text/parse");
        intent_feedback_actions.putExtra(Intent.EXTRA_EMAIL, "feedback@ampuappi.com");          // TODO mailiosoite ei siirry mukana
        intent_feedback_actions.putExtra(Intent.EXTRA_SUBJECT, "Palautetta sovellukseta");
        intent_feedback_actions.putExtra(Intent.EXTRA_TEXT, "joo"+feed);                        // TODO edittexstistä saatu teksti sekoittuu koodiksi
        startActivity(Intent.createChooser(intent_feedback_actions, "Lähtä sähköposti"));

    }
}