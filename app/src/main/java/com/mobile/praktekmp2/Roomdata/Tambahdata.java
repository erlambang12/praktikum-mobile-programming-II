package com.mobile.praktekmp2.Roomdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobile.praktekmp2.Entity.Mahasiswa;
import com.mobile.praktekmp2.R;

import static com.mobile.praktekmp2.Roomdata.Myapp.db;

public class Tambahdata extends AppCompatActivity {
    EditText namamaha;
    EditText NIM;
    EditText jurusan;
    Mahasiswa mahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahdata);
        namamaha = findViewById(R.id.namamaha);
        NIM = findViewById(R.id.NIM);
        jurusan = findViewById(R.id.jurusan);
        Button tambah = findViewById(R.id.butam);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahdata();
            }
        });
    }
    private void tambahdata(){
        if(!namamaha.getText().toString().isEmpty()&&!NIM.getText().toString().isEmpty()&&!jurusan.getText().toString().isEmpty()){
            mahasiswa = new Mahasiswa();
            mahasiswa.setNamamahasiswa(namamaha.getText().toString());
            mahasiswa.setNIM(NIM.getText().toString());
            mahasiswa.setJurusan(jurusan.getText().toString());
            db.userDao().insertAll(mahasiswa);
            startActivity(new Intent(Tambahdata.this,RoomData.class));
        }
        else {
            Toast.makeText(this,"yang benar lur !",Toast.LENGTH_SHORT).show();
        }
    }
}