package projekti.ampuappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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



    }

    public void onClick_exit_FB(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickListener_to_email(View view)
    {

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "feedback@ampuappi.com", null));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Palautetta");
        startActivity(Intent.createChooser(intent, "Choose an Email client :"));
    }

}