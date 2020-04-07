package com.example.componentsgallery.components.expandable_recyclerview;

import android.os.Bundle;

import com.example.componentsgallery.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private List<Item> elements;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter listAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_recyclerview_page);

        bindViews();
        initializeRecyclerView();
    }

    private void bindViews(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_list);
    }

    private void initializeRecyclerView(){
        elements = initializeList();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        listAdapter = new ExpRecyclerView(elements);
        recyclerView.setAdapter(listAdapter);
    }

    private List<Item> initializeList(){
        List<Item> elements = new ArrayList<>();
        int number = 20;

        for (int i=0; i<number; i++){
            Item item = new Item();
            item.setDate("date_sample #" + i);
            item.setDescription("description_sample #" + i);
            item.setEndDate("endDate_sample #" + i);
            item.setStartDate("startDate_sample #" + i);
            item.setLocation("location_sample #" + i);
            elements.add(item);
        }
        return elements;
    }
}
