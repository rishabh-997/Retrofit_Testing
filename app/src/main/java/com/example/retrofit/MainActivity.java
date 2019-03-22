package com.example.retrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    ArrayList<Hero> arrayList;
    HeroRecyclerViewAdapter heroRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();
        heroRecyclerViewAdapter =new HeroRecyclerViewAdapter(this,arrayList);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        getHeroes();
    }

    private void getHeroes()
    {
        final ProgressDialog progressDialog=new ProgressDialog(this) ;
        progressDialog.setMessage("Loading");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<ArrayList<Hero>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Hero>> call, Response<ArrayList<Hero>> response)
            {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"In here", Toast.LENGTH_SHORT).show();

                List<Hero> herolist=response.body();
                for(int i=0;i<herolist.size();i++)
                {
                    String name=herolist.get(i).getName();
                    String realname=herolist.get(i).getRealname();
                    String team=herolist.get(i).getTeam();
                    String url=herolist.get(i).getImageurl();
                    arrayList.add(new Hero(name,realname,team,url));
                    heroRecyclerViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Hero>> call, Throwable t)
            {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.setAdapter(heroRecyclerViewAdapter);
    }
}