package com.gts.cakrainventorybeta2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Manager_Login extends AppCompatActivity
{
    private ImageView managerLogin_imageView;

    private EditText manager_LoginUserName, manager_LoginPassword;
    private TextView manager_LoginButton;
    private TextView manager_LoginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager__login);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        managerLogin_imageView=findViewById(R.id.managerLogin_imageView);

        manager_LoginUserName = findViewById(R.id.manager_LoginUserName);
        manager_LoginPassword = findViewById(R.id.manager_LoginPassword);
        manager_LoginButton = findViewById(R.id.manager_LoginButton);
        manager_LoginTextView = findViewById(R.id.manager_LoginTextView);


        Animation managerloginTextAnimation = AnimationUtils.loadAnimation(Manager_Login.this, R.anim.blink_animation);
        manager_LoginTextView.setAnimation(managerloginTextAnimation);

        Animation managerLoginImageAnimation= AnimationUtils.loadAnimation(Manager_Login.this, R.anim.left_to_right_animation);
        managerLogin_imageView.setAnimation(managerLoginImageAnimation);


        manager_LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validIdPassword(manager_LoginUserName.getText().toString(), manager_LoginPassword.getText().toString());
            }
        });

    }

    private void validIdPassword(String userName, String userPassword){

        if ((userName.equals("Adit")) && (userPassword.equals("12345"))){

            Intent managerLoginIntent= new Intent(Manager_Login.this, Manager_Main.class);
            startActivity(managerLoginIntent);

        }
        else if ((userName.equals("Winton")) && (userPassword.equals("12345"))){

            Intent managerLoginIntent= new Intent(Manager_Login.this, Manager_Main.class);
            startActivity(managerLoginIntent);

        }
        else if ((userName.equals("Jefry")) && (userPassword.equals("12345"))){

            Intent managerLoginIntent= new Intent(Manager_Login.this, Manager_Main.class);
            startActivity(managerLoginIntent);

        }

        else{

            Toast.makeText(Manager_Login.this, "Mohon masukan data yang valid", Toast.LENGTH_SHORT).show();
        }
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
