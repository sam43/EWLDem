package example.saadat.com.ewldemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


/**
 * Created by Saadat on 8/13/2016.
 */
public class Recommended extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String[] Title1;
    String[] Title2;
    int[] img = {R.drawable.im1,R.drawable.im3,R.drawable.im6,R.drawable.im7,R.drawable.im8,R.drawable.im10,R.drawable.im12};
    ArrayList<Data> arrayList = new ArrayList<Data>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.recommended, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.hotsell);

        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Title1 = getResources().getStringArray(R.array.brand_name);
        Title2 = getResources().getStringArray(R.array.item_name);

        int i=0;
        //for(i=0; i<=2; i++) {
        for (String name : Title1) {
            Data data = new Data(img[i], name, Title2[i]);
            arrayList.add(data);
            i++;
        }

        adapter = new RecyclerAdapter(arrayList);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        } else {
            linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
