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

    public SliderAdapter(Context context, int value)
    {
        this.context = context;
        mikaSynnytys = value;
    }

    // Arrayt slideri tietoihin!!! Jokaiselle omalle synnytystapahtumalle omansa

    public int[] slide_images = {


            R.drawable.ohje,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7

    };

    public int[] slide_images2 = {


            R.drawable.ohje7,
            R.drawable.ohje3,
            R.drawable.ohje4,
            R.drawable.ohje5,
            R.drawable.ohje7

    };



    public String[] slide_header = {

            "Eka",
            "Toka",
            "Kolmas",
            "Neljas",
            "Viides"
    };

    public int[] slide_text = {

            R.string.eka_Dia,
            R.string.toka_Dia,
            R.string.kolmas_Dia,
            R.string.neljas_Dia,
            R.string.viides_Dia
    };

    public int[] slide_text2 = {

            R.string.eka_Dia2,
            R.string.toka_Dia2,
            R.string.kolmas_Dia2,
            R.string.neljas_Dia2,
            R.string.viides_Dia2
    };

    // luo automaattisesti tehtäessä kun extendaa PageAdapterin
    @Override
    public int getCount() {
        return slide_header.length;
    }

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
        TextView slideText =   view.findViewById(R.id.id_textView);

        if (mikaSynnytys == 1)
        {
            slideImageView.setImageResource(slide_images[position]);
            slideHeader.setText(slide_header[position]);
            slideText.setText(slide_text[position]);
        }
        if (mikaSynnytys == 2)
        {
            slideImageView.setImageResource(slide_images2[position]);
            slideHeader.setText(slide_header[position]);
            slideText.setText(slide_text2[position]);
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