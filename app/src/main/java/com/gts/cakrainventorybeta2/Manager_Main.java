package com.gts.cakrainventorybeta2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Manager_Main extends AppCompatActivity
{
    private TextView product_info;
    private ImageView managerMain_imageView;

    private EditText NIK, Jabatan ,Usia,Name;
    private CardView barcode_Scanner;
    private TextView save_Info, view_Info;
    private Spinner JenisKelamin;

    private Product_Info productInfo;
    FirebaseDatabase database;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager__main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        product_info=findViewById(R.id.product_info);
        managerMain_imageView=findViewById(R.id.managerMain_imageView);

        NIK=findViewById(R.id.NIK);
        Name=findViewById(R.id.inventoryName);
        Usia =findViewById(R.id.Usia);
        JenisKelamin=findViewById(R.id.jeniskelamin);
        Jabatan = findViewById(R.id.jabatan);

        barcode_Scanner=findViewById(R.id.barcode_Scanner);
        save_Info=findViewById(R.id.save_Info);
        view_Info=findViewById(R.id.view_Info);


        productInfo= new Product_Info();
        database=FirebaseDatabase.getInstance();
        mRef=database.getReference().child("Informasi Karyawan");


        Animation managerMainImage_Animation = AnimationUtils.loadAnimation(Manager_Main.this, R.anim.left_to_right_animation);
        managerMain_imageView.setAnimation(managerMainImage_Animation);

        Animation managerCamera_Animation = AnimationUtils.loadAnimation(Manager_Main.this, R.anim.right_to_left_animation);
        barcode_Scanner.setAnimation(managerCamera_Animation);

        Animation productInfoAnimation = AnimationUtils.loadAnimation(Manager_Main.this, R.anim.blink_animation);
        product_info.setAnimation(productInfoAnimation);


        barcode_Scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent manager_barcodeScan= new Intent(Manager_Main.this, Members_Scanning.class);
                startActivity(manager_barcodeScan);
            }
        });



        save_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean error = false;

                String nik=NIK.getText().toString();
                if (nik.isEmpty()) {
                    NIK.setError("Kode Karyawan Kosong");
                    error = true;
                }

                String name=Name.getText().toString();
                if (name.isEmpty()) {
                    Name.setError("Nama Karyawan Masih Kosong");
                    error = true;
                }

                String usia= Usia.getText().toString();
                if (usia.isEmpty()) {
                    Usia.setError("Usia Masih Kosong");
                    error = true;
                }

                String jabatan=Jabatan.getText().toString();
                if (jabatan.isEmpty()) {
                    Jabatan.setError("Ukuran Inventory Kosong");
                    error = true;
                }

                String jeniskelamin=JenisKelamin.getSelectedItem().toString();


                productInfo.setNik(nik);
                productInfo.setName(name);
                productInfo.setUsia(usia);
                productInfo.setJabatan(jabatan);
                productInfo.setJenisKelamin(jeniskelamin);

                if (error==true){

                    Toast.makeText(Manager_Main.this, "Informaasi Data Tidak Valid", Toast.LENGTH_LONG).show();

                }
                else {

                    mRef.child(productInfo.getNik()).setValue(productInfo);
                    Toast.makeText(Manager_Main.this, "Informasi Data Telah Diterima", Toast.LENGTH_LONG).show();

                }

            }


        });



        view_Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent viewInfo=new Intent(Manager_Main.this,View_Information.class);
                startActivity(viewInfo);
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
