package com.gts.cakrainventorybeta2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class View_Information extends AppCompatActivity
{
    private ListView listView;
    private String string;

    FirebaseDatabase database;
    DatabaseReference ref;

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    Product_Info productInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__information);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView=findViewById(R.id.listView);


        productInfo=new Product_Info();

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Informasi Karyawan");


        list=new ArrayList<>();
        adapter= new ArrayAdapter<String>(View_Information.this, R.layout.product_info_layout, R.id.info_TextView, list);


        ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    productInfo= ds.getValue(Product_Info.class);

                    list.add("NIK :  "+productInfo.getNik() +"\n\n"+  "Nama Karyawan :   "+productInfo.getName()+"\n"+
                             "Usia :   "+productInfo.getUsia()+"\n"+ "Jabatan :   "+productInfo.getJabatan()+"\n"+
                            "Status :   "+productInfo.getStatus()+"\n"+   "Jenis Kelamin :   "+productInfo.getJenisKelamin());
                }

                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);

    }
}