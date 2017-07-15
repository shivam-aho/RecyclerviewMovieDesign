package com.letsmath.recyclerviewmoviedesign;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by root on 14/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder > {

    private Context mContext;
    private ArrayList<CompleteDataPojoClass> mcompleteDataPojoClassArrayList;
    LayoutInflater lif;

    MyAdapter(Context context, ArrayList<CompleteDataPojoClass> completeDataPojoClassArrayList)
  {
      this.mContext=context;
      this.mcompleteDataPojoClassArrayList=completeDataPojoClassArrayList;
      lif=LayoutInflater.from(mContext);
  }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(lif.inflate(R.layout.outeritemlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.heading.setText(mcompleteDataPojoClassArrayList.get(position).headingdata);
        holder.innerrecyclerview.setHasFixedSize(true);
        holder.innerrecyclerview.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        InnerAdapter innerAdapter=new InnerAdapter(mContext,mcompleteDataPojoClassArrayList.get(position).singleitemarraylistdata);
        holder.innerrecyclerview.setAdapter(innerAdapter);
        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"nothing to show",Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mcompleteDataPojoClassArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public RecyclerView innerrecyclerview;
        public TextView heading;
        public Button moreBtn;
        public ViewHolder(View itemView) {
        super(itemView);
        heading=(TextView)itemView.findViewById(R.id.heading);
        moreBtn=(Button) itemView.findViewById(R.id.morebtn);
        innerrecyclerview=(RecyclerView) itemView.findViewById(R.id.innerrecyclerview);
    }
}
}

 class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ViewHolder>
        {
            private final Context context;
            private  final ArrayList<SingleItemPojoClass> singleItemPojoClassArrayList;
            private final LayoutInflater lif;

            InnerAdapter(Context context, ArrayList<SingleItemPojoClass> singleItemPojoClassArrayList)
            {
                this.context=context;
                this.singleItemPojoClassArrayList=singleItemPojoClassArrayList;
                lif=LayoutInflater.from(context);
            }
            @Override
            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(lif.inflate(R.layout.inneritemlayout,parent,false));
            }

            @Override
            public void onBindViewHolder(ViewHolder holder, final int position) {
                holder.movieImage.setImageResource(singleItemPojoClassArrayList.get(position).itemimagedata);
                holder.movieImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context,position+1+" movie selected",Toast.LENGTH_LONG).show();
                    }
                });

                holder.movietitle.setText(singleItemPojoClassArrayList.get(position).itemnamedata);
            }

            @Override
            public int getItemCount() {
                return singleItemPojoClassArrayList.size();
            }

            class ViewHolder extends RecyclerView.ViewHolder {
                private  TextView movietitle;
                private  ImageView movieImage;

                public ViewHolder(View itemView) {
                super(itemView);
                movieImage=(ImageView)itemView.findViewById(R.id.movieposter);
                movietitle=(TextView)itemView.findViewById(R.id.movietitle);

            }
        }
        }
