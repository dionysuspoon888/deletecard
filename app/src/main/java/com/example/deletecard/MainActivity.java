package com.example.deletecard;

import android.support.v7.widget.RecyclerView;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements JsonRecyclerViewAdapter.OnItemClickListener {
    //DATE TRANSMITTED KEY
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";
    public static final String EXTRA_VIEWS = "viewCount";

    //RecyclerView setting
    public RecyclerView recyclerView;
    public JsonRecyclerViewAdapter adapter;
    public ArrayList<JSONItem> list = new ArrayList<>();

    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delete = findViewById(R.id.b);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        //RecyclerView setting
        recyclerView = findViewById(R.id.recycler_view);
        //better performance
        recyclerView.setHasFixedSize(true);
        //grid view
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        list.add(new JSONItem("abc", "delete"));
        list.add(new JSONItem("abc", "delete"));



        initView(false);

    }

    public void initView(boolean show){
        adapter = new JsonRecyclerViewAdapter(MainActivity.this, list,show);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(MainActivity.this);


    }

    public void show(){
        initView(true);

    }


    //Override OnClick method in JsonRecyclerViewAdapter
    @Override
    public void onItemClick(int position,TextView textViewCreator) {
        adapter = new JsonRecyclerViewAdapter(MainActivity.this, list,false); //new adapter requries to setAdapter

        list.remove(position);//Remove it from the List (otherwise,it would keep adding to the  RecyclerView)
      // adapter.notifyItemRemoved(position);// for delete

        //adapter.notifyAll(); // ???
        //adapter.notifyDataSetChanged(); // for everything


       recyclerView.setAdapter(adapter); //refresh after setting

    }





}