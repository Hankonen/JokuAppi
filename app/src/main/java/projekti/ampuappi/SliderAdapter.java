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

        arrayListEkavaiheTitle = json.get_json("avautumisvaihe", "title");
        arrayListEkavaiheTeksti = json.get_json("avautumisvaihe", "body");

        arrayListPonnistusVaiheTitle = json.get_json("ponnistusvaihe", "title");
        arrayListPonnistusVaiheTeksti = json.get_json("ponnistusvaihe", "body");

        arrayListVikaVaiheTitle = json.get_json("jälkeisvaihe", "title");
        arrayListVikaVaiheTeksti = json.get_json("jälkeisvaihe", "body");

        arrayListPeratilaTitle = json.get_json("Perätila", "title");
        arrayListPeratilaTeksti = json.get_json("Perätila", "body");

        arrayListNapanuoraTitle = json.get_json("Napanuora", "title");
        arrayListNapanuoraTeksti = json.get_json("Napanuora", "body");

        arrayListHartiaTitle = json.get_json("Hartiadystokia", "title");
        arrayListHartiaTeksti = json.get_json("Hartiadystokia", "body");


    }



    // Arrayt slideri tietoihin!!! Näissä tietona mitkä tiedot mihinki esitykseen. Kuvat, otsikot ja teksti. Tämä on buginen paska, eli arrayn pituus ei vastaa tuotua sivumäärää esityksessä niin mahd. kaatuu

    public int[] peratila_slides = {


            R.drawable.ohje,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7
    };

    public int[] napanuora_slides = {

            R.drawable.ohje4,
            R.drawable.ohje4,
            R.drawable.ohje4,
            R.drawable.ohje7,
            R.drawable.ohje7
    };

    public int[] hartiadystokia_slides = {

            R.drawable.ohje7,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7
    };

    public int[] ensimmainenvaihe_slides = {

            R.drawable.ohje5,
            R.drawable.ohje5
    };

    public int[] normaalitila_slides = {

            R.drawable.ohje7,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7
    };

    public int[] kolmasvaihe_slides = {

            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje
    };

    public String[] peratila_header = {

            "Perätila",//JSONtieto,  // TODO ÄLÄ KOVAKOODAA
            "Perätila",
            "Perätila",
            "Perätila",
            "Perätila"
    };

    public String[] normaalitila_header = {

            "Ponnistusvaihe, normaalisynnytys",
            "Ponnistusvaihe, normaalisynnytys",
            "Ponnistusvaihe, normaalisynnytys",
            "Ponnistusvaihe, normaalisynnytys",
            "Ponnistusvaihe, normaalisynnytys"
    };

    public String[] napanuora_header = {

            "Napanuora",
            "Napanuora",
            "Napanuora",
            "Napanuora",
            "Napanuora"
    };

    public String[] hartiadystokia_header = {

            "Hartiadystokia",
            "Hartiadystokia",
            "Hartiadystokia",
            "Hartiadystokia",
            "Hartiadystokia"
    };

    public String[] ensimmainenvaihe_header = {

            "Avautumisvaihe",
            "Avautumisvaihe"
    };

    public String[] kolmasvaihe_header = {

            "Jälkeisvaihe",
            "Jälkeisvaihe",
            "Jälkeisvaihe",
            "Jälkeisvaihe",
            "Jälkeisvaihe",
    };



    public int[] slide_text_normaali = {

            R.string.eka_Dia_Normaali,
            R.string.toka_Dia_Normaali,
            R.string.kolmas_Dia_Normaali,
            R.string.neljas_Dia_Normaali,
            R.string.viides_Dia_Peratila
    };

    public int[] slide_text_peratila = {

            R.string.eka_Dia_Peratila,
            R.string.toka_Dia_Peratila,
            R.string.kolmas_Dia_Peratila,
            R.string.neljas_Dia_Peratila,
            R.string.viides_Dia_Peratila
    };

    public int[] slide_text_ensimmainenvaihe = {

            R.string.eka_Dia_Ensimmainenvaihe,

    };

    public int[] slide_text_hartiadystokia = {

            R.string.eka_Dia_Hartiadystokia,
            R.string.toka_Dia_Hartiadystokia,
            R.string.kolmas_Dia_Hartiadystokia,
            R.string.neljas_Dia_Hartiadystokia,
            R.string.viides_Dia_Hartiadystokia
    };

    public int[] slide_text_napanuora = {

            R.string.eka_Dia_Napanuora,
            R.string.toka_Dia_Napanuora,
            R.string.kolmas_Dia_Napanuora,
            R.string.neljas_Dia_Napanuora,
            R.string.viides_Dia_Napanuora
    };

    public int[] slide_text_kolmasvaihe = {

            R.string.eka_Dia_Kolmasvaihe,
            R.string.toka_Dia_Kolmasvaihe,
            R.string.kolmas_Dia_Kolmasvaihe,
            R.string.neljas_Dia_Kolmasvaihe,
            R.string.viides_Dia_Kolmasvaihe,
            R.string.viides_Dia_Normaali,
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