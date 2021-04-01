package projekti.ampuappi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public int mikaSynnytys;
    public int sivumaara;

    public SliderAdapter(Context context, int arvo, int pSivumaara)
    {
        this.context = context;
        mikaSynnytys = arvo;
        sivumaara = pSivumaara;
    }

    // Arrayt slideri tietoihin!!!

    public int[] peratila_slides = {

            R.drawable.ohje,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7

    };

    public int[] normaalitila_slides = {

            R.drawable.ohje7,
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

    public int[] kolmasvaihe_slides = {

            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje,
            R.drawable.ohje
    };

    public String[] peratila_header = {


            "Eka",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides"
    };

    public String[] normaalitila_header = {


            "Eka",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides"
    };

    public String[] napanuora_header = {


            "Napanuora",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides"
    };

    public String[] hartiadystokia_header = {


            "Eka",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides"
    };

    public String[] ensimmainenvaihe_header = {


            "Eka",
            "toka"

    };

    public String[] kolmasvaihe_header = {


            "Eka",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides",

    };

    public int[] slide_text_normaali = {

            R.string.eka_Dia_Normaali,
            R.string.toka_Dia_Normaali,
            R.string.kolmas_Dia_Normaali,
            R.string.neljas_Dia_Normaali


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

    //
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.id_ImageView);
        TextView slideHeader = (TextView) view.findViewById(R.id.id_TextLabel);
        TextView slideText = (TextView) view.findViewById(R.id.id_textView);


        if (mikaSynnytys == 1)
        {
            slideImageView.setImageResource(peratila_slides[position]);
            slideHeader.setText(peratila_header[position]);
            slideText.setText(slide_text_normaali[position]);
        }

        if (mikaSynnytys == 2)
        {
            slideImageView.setImageResource(normaalitila_slides[position]);
            slideHeader.setText(normaalitila_header[position]);
            slideText.setText(slide_text_peratila[position]);
        }
        if (mikaSynnytys == 3)
        {
            slideImageView.setImageResource(hartiadystokia_slides[position]);
            slideHeader.setText(hartiadystokia_header[position]);
            slideText.setText(slide_text_hartiadystokia[position]);
        }

        if (mikaSynnytys == 4)
        {
            slideImageView.setImageResource(napanuora_slides[position]);
            slideHeader.setText(napanuora_header[position]);
            slideText.setText(slide_text_napanuora[position]);
        }
        if (mikaSynnytys == 5)
        {

            slideImageView.setImageResource(ensimmainenvaihe_slides[position]);
            slideHeader.setText(ensimmainenvaihe_header[position]);
            slideText.setText(slide_text_ensimmainenvaihe[position]);
        }

        if (mikaSynnytys == 6)
        {
            slideImageView.setImageResource(kolmasvaihe_slides[position]);
            slideHeader.setText(kolmasvaihe_header[position]);
            slideText.setText(slide_text_kolmasvaihe[position]);
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