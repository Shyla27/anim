package com.example.myapplication.anim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private static final int NUM_COLUMNS = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_list);

        initImageBitmaps();

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://www.pinterest.com/pin/840976930402606202/");
        mNames.add("chuck");

        mImageUrls.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fisdesign.info%2Fbusiness-and-management%2Fthe-evolution-of-fine-art%2F&psig=AOvVaw3Y_xyXiIq63CYzf68bNldH&ust=1588921706126000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNioxOOYoekCFQAAAAAdAAAAABAI");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.standardmedia.co.ke%2Fbusiness%2Farticle%2F2001333292%2Fthe-fine-art-of-business&psig=AOvVaw3Y_xyXiIq63CYzf68bNldH&ust=1588921706126000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNioxOOYoekCFQAAAAAdAAAAABAO");
        mNames.add("paint");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        mImageUrls.add(String.valueOf(R.drawable.chuck));
        mNames.add("ass");

        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview" );

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
          return true;
    }
}
