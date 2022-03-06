package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.historicalplaces.R;

import java.util.ArrayList;

import Model.Place;

/**
 * created by ariadiki on 06/02/2022
 **/
public class Place_Adapter extends BaseAdapter {
    ArrayList<Place> places = new ArrayList<>();
    Context context;

    public Place_Adapter(ArrayList<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView name,rate;
        ImageView image;
        Button btn_rate;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_list,viewGroup,false);

        name =(TextView) view.findViewById(R.id.name);
        rate =(TextView) view.findViewById(R.id.rate);
        image =(ImageView) view.findViewById(R.id.image);
        btn_rate =(Button) view.findViewById(R.id.btn_rate);

        name.setText(places.get(i).getName());
        rate.setText(String.valueOf(places.get(i).getRate()));
        image.setImageResource(places.get(i).getImage());

        btn_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                places.get(i).increment();
                rate.setText(String.valueOf(places.get(i).getRate()));
            }
        });
        return view;
    }
}
