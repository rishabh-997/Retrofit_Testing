package com.example.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HeroRecyclerViewAdapter extends RecyclerView.Adapter<HeroRecyclerViewAdapter.ViewHolder>
{
    Context context;
    ArrayList<Hero> arrayList;
    public HeroRecyclerViewAdapter(Context context, ArrayList<Hero> arrayList)
    {
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        Hero sample=arrayList.get(i);
        String naam=sample.getName();
        String aslinaam=sample.getRealname();
        String teaming=sample.getTeam();
        String url=sample.getImageurl();

        viewHolder.hero_name.setText(naam);
        viewHolder.hero_realname.setText(aslinaam);
        viewHolder.hero_team.setText(teaming);

        Glide.with(context).load(url).into(viewHolder.hero_pic);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView hero_pic;
        TextView hero_name,hero_realname,hero_team;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            hero_name=itemView.findViewById(R.id.hero_name);
            hero_realname=itemView.findViewById(R.id.hero_realname);
            hero_team=itemView.findViewById(R.id.hero_team);
            hero_pic=itemView.findViewById(R.id.hero_image);
        }
    }
}
