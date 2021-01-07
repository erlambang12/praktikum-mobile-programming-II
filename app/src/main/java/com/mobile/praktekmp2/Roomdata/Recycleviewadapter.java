package com.mobile.praktekmp2.Roomdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.praktekmp2.Entity.Mahasiswa;
import com.mobile.praktekmp2.R;

import java.util.List;

public class Recycleviewadapter extends RecyclerView.Adapter<Recycleviewadapter.myviewholder> {
    private Context mcontext;
    private List<Mahasiswa>albumlist;
    public class myviewholder extends RecyclerView.ViewHolder{
        TextView namamahasiswa,NIM,jurusan;
        public myviewholder(View a){
            super(a);
            namamahasiswa = a.findViewById(R.id.tvnamamahas);
            NIM = a.findViewById(R.id.tvNIM);
            jurusan = a.findViewById(R.id.tvjurusan);

        }
    }
    public Recycleviewadapter(Context mcontext,List<Mahasiswa>albumlist){
        this.mcontext =  mcontext;
        this.albumlist = albumlist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa,parent,false);
        return new myviewholder(itemview);
    }

    @Override
    public void onBindViewHolder(final myviewholder holder,int position){
        final Mahasiswa album = albumlist.get(position);
        holder.namamahasiswa.setText(album.getNamamahasiswa());
        holder.NIM.setText(album.getNIM());
        holder.jurusan.setText(album.getJurusan());
    }

    @Override
    public int getItemCount() {
        return albumlist.size();
    }
}
