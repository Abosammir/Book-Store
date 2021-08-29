package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.bookstore.model.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Animation topAnim,botAnim ;
    TextView text1,text2 ;
    DatabaseReference firebaseDatabase ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Users");

        Users users = new Users("ةخةخةخ" , "+201000" , "Hazem Elnahas" , "01256");

        firebaseDatabase.push().setValue(users);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Button button = findViewById(R.id.get_started);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,loginActivity.class);
                startActivity(intent);
                finish();

            }
        });

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this,R.anim.bot_animation);

        text1=findViewById(R.id.textView1);
        text2=findViewById(R.id.textView2);

        text1.setAnimation(topAnim);
        text2.setAnimation(topAnim);
        button.setAnimation(botAnim);

    }
}