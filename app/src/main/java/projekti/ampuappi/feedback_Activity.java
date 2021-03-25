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

        Intent intent2 = new Intent(Intent.ACTION_SEND);
        intent2.setType("text/html");
        intent2.putExtra(Intent.EXTRA_EMAIL, "feedback@ampuappi.com");
        intent2.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        intent2.putExtra(Intent.EXTRA_TEXT, "joo"+feed);
        startActivity(Intent.createChooser(intent2, "Send Email"));

    }
}