package com.letsmath.recyclerviewmoviedesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.myrecyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setHasFixedSize(true);
        ArrayList<CompleteDataPojoClass> completeDataPojoClassArrayList=new ArrayList<CompleteDataPojoClass>();
        for(int i=1;i<5;i++)
        {
            CompleteDataPojoClass completeDataPojoClass=new CompleteDataPojoClass();
            completeDataPojoClass.headingdata="heading"+String.valueOf(i);
            ArrayList<SingleItemPojoClass> singleItemPojoClassArrayList=new ArrayList<SingleItemPojoClass>();
            for(int j=1;j<9;j++)
            {
                SingleItemPojoClass singleItemPojoClass =new SingleItemPojoClass();
                singleItemPojoClass.itemimagedata=R.drawable.jabwemet;
                singleItemPojoClass.itemnamedata="image"+String.valueOf(j);
                singleItemPojoClassArrayList.add(singleItemPojoClass);
            }
            completeDataPojoClass.singleitemarraylistdata=singleItemPojoClassArrayList;
            completeDataPojoClassArrayList.add(completeDataPojoClass);
        }
        MyAdapter myAdapter=new MyAdapter(MainActivity.this,completeDataPojoClassArrayList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
