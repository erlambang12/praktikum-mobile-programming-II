package com.mobile.praktekmp2.Roomdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.mobile.praktekmp2.Entity.Mahasiswa;
import com.mobile.praktekmp2.R;

import java.util.ArrayList;
import java.util.List;

import static com.mobile.praktekmp2.Roomdata.Myapp.db;

public class Viewdata extends AppCompatActivity {
    RecyclerView myrecycle;
    Recycleviewadapter myadapter;
    List<Mahasiswa> listmahasiswa = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdata);
        myrecycle = findViewById(R.id.myRecyclerview);

        fetchdata();
        initrecycle();
        setadapter();
    }
    private void fetchdata(){
        db = Room.databaseBuilder(getApplicationContext(),
                Databaseapp.class, "mahasiswa").allowMainThreadQueries().build();
        listmahasiswa = db.userDao().getAll();

        for (int i = 0;i<listmahasiswa.size();i++){
            Log.e("Aplikasi", listmahasiswa.get(i).getNamamahasiswa()+i);
            Log.e("Aplikasi", listmahasiswa.get(i).getNIM()+i);
            Log.e("Aplikasi", listmahasiswa.get(i).getJurusan()+i);
        }
    }
    public void initrecycle(){
        myrecycle.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myrecycle.setLayoutManager(llm);
        myadapter = new Recycleviewadapter(this,listmahasiswa);
    }
    private void setadapter(){myrecycle.setAdapter(myadapter);}
}