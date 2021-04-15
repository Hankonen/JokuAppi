package projekti.ampuappi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class JSON extends AppCompatActivity {

    private ArrayList<String> palautettavaTeksti;
    private String avain;


    private InputStream is;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private String json;

    public JSON(String pAvain)
    {
        avain = pAvain;
    }

    public void setKey(String pAvain, Context context)
    {

        try {
            is = context.getAssets().open("db.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray(pAvain);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> get_json(String pVaihe, String pHaettavaTieto)
    {
        palautettavaTeksti = new ArrayList<String>();

        if (pHaettavaTieto == "title")
        {
            for (int i = 0; i < jsonArray.length(); i++)
            {
                try {

                    JSONObject object = jsonArray.getJSONObject(i);
                    //Log.d("apua", palautettavaTeksti.toString());

                    if (object.getString("title").equals(pVaihe) )
                    {

                        palautettavaTeksti.add(object.getString(pHaettavaTieto));
                        Log.d("JSONISSA", palautettavaTeksti.toString());
                    }
                } catch (Exception e)
                {

                }


            }
        }
        else if (pHaettavaTieto == "body")
        {
            for (int i = 0; i < jsonArray.length(); i++)
            {
                try {

                    JSONObject object = jsonArray.getJSONObject(i);


                    if (object.getString("title").equals(pVaihe) )
                    {
                        palautettavaTeksti.add(object.getString(pHaettavaTieto));
                    }
                } catch (Exception e)
                {

                }
            }
        }
        return palautettavaTeksti;
    }
}
