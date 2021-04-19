package projekti.ampuappi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public int mikaSynnytys;
    public int sivumaara;
    JSON json;

    //public
    // Tuodaan parametrinä MainActivitystä saatu tieto mikä synnytystapahtuma ja montako sivua esityksessä on

    // TODO tee kaikille slaideriinfoille sama homma!!!, tsekkaa myös diojen määrät oikeaksi
    private ArrayList<String> arrayListEkavaiheTitle, arrayListEkavaiheTeksti, arrayListPonnistusVaiheTitle, arrayListPonnistusVaiheTeksti, arrayListVikaVaiheTitle, arrayListVikaVaiheTeksti,
            arrayListPeratilaTitle, arrayListPeratilaTeksti, arrayListNapanuoraTitle, arrayListNapanuoraTeksti, arrayListHartiaTitle, arrayListHartiaTeksti;


    public SliderAdapter(Context context, int pArvo, int pSivumaara)
    {
        this.context = context;
        mikaSynnytys = pArvo;
        sivumaara = pSivumaara;

        json = new JSON("pokemon");

        json.setKey("pokemon", this.context);

        arrayListEkavaiheTitle = json.get_json("first", "title");
        arrayListEkavaiheTeksti = json.get_json("first", "body");

        arrayListPonnistusVaiheTitle = json.get_json("second", "title");
        arrayListPonnistusVaiheTeksti = json.get_json("second", "body");

        arrayListVikaVaiheTitle = json.get_json("third", "title");
        arrayListVikaVaiheTeksti = json.get_json("third", "body");

        arrayListPeratilaTitle = json.get_json("fourth", "title");
        arrayListPeratilaTeksti = json.get_json("fourth", "body");

        arrayListNapanuoraTitle = json.get_json("fifth", "title");
        arrayListNapanuoraTeksti = json.get_json("fifth", "body");

        arrayListHartiaTitle = json.get_json("sixsth", "title");
        arrayListHartiaTeksti = json.get_json("sixsth", "body");


    }



    // Arrayt slideri tietoihin!!! Näissä tietona mitkä tiedot mihinki esitykseen. Kuvat, otsikot ja teksti. Tämä on buginen paska, eli arrayn pituus ei vastaa tuotua sivumäärää esityksessä niin mahd. kaatuu

    public int[] peratila_slides = {


            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    public int[] napanuora_slides = {

            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    public int[] hartiadystokia_slides = {

            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    public int[] ensimmainenvaihe_slides = {

            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    public int[] normaalitila_slides = {

            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    public int[] kolmasvaihe_slides = {

            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum,
            R.drawable.loremipsum
    };

    // luo automaattisesti tehtäessä kun extendaa PageAdapterin
    @Override
    public int getCount() {
        return sivumaara;
    }   //TODO tee tästä skaalautuva

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    // vaaditaan inflantoimaan kaikki tässä adapterissa
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {



        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);




        // Asetetaan oikeat tiedot arrayista
        ImageView slideImageView = (ImageView) view.findViewById(R.id.id_ImageView);
        TextView slideHeader = (TextView) view.findViewById(R.id.id_TextLabel);
        TextView slideText = (TextView) view.findViewById(R.id.id_textViewToLocation);

        // normaalitila 2 vaihe
        if (mikaSynnytys == 1)
        {

            slideImageView.setImageResource(normaalitila_slides[position]);
            slideHeader.setText(arrayListPonnistusVaiheTitle.get(position));
            slideText.setText(arrayListPonnistusVaiheTeksti.get(position));
            Log.d("apua",arrayListPonnistusVaiheTitle.toString());
        }

        // perätila
        if (mikaSynnytys == 2)
        {
            slideImageView.setImageResource(peratila_slides[position]);
            slideHeader.setText(arrayListPeratilaTitle.get(position));
            slideText.setText(arrayListPeratilaTeksti.get(position));
        }
        if (mikaSynnytys == 3)
        {
            slideImageView.setImageResource(hartiadystokia_slides[position]);
            slideHeader.setText(arrayListHartiaTitle.get(position));
            slideText.setText(arrayListHartiaTeksti.get(position));
        }

        if (mikaSynnytys == 4)
        {
            slideImageView.setImageResource(napanuora_slides[position]);
            slideHeader.setText(arrayListNapanuoraTitle.get(position));
            slideText.setText(arrayListNapanuoraTeksti.get(position));
        }
        if (mikaSynnytys == 5)
        {
            slideImageView.setImageResource(ensimmainenvaihe_slides[position]);
            slideHeader.setText(arrayListEkavaiheTitle.get(position));
            slideText.setText(arrayListEkavaiheTeksti.get(position));


        }

        if (mikaSynnytys == 6)
        {
            slideImageView.setImageResource(kolmasvaihe_slides[position]);
            slideHeader.setText(arrayListVikaVaiheTitle.get(position));
            slideText.setText(arrayListVikaVaiheTeksti.get(position));
        }

        container.addView(view);

        return view;
    }

    // kun tullaan viimeiselle sivulle niin pysähtyy, estää päällekkäiset slidet

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }


}