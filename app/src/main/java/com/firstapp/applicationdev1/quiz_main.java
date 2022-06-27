package com.firstapp.applicationdev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class quiz_main extends AppCompatActivity {

    Button startbtn;
    private String selectedTopicnName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        final LinearLayout java = findViewById(R.id.javalayout);
        final LinearLayout python = findViewById(R.id.pytonlayout);
        final LinearLayout webprog = findViewById(R.id.webproglayout);
        final LinearLayout cplusplus = findViewById(R.id.cpluslayout);

        startbtn = findViewById(R.id.startQuizBtn);

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicnName = "java";
                java.setBackgroundResource(R.drawable.white_background_stroke);

                python.setBackgroundResource(R.drawable.round_back_10);
                webprog.setBackgroundResource(R.drawable.round_back_10);
                cplusplus.setBackgroundResource(R.drawable.round_back_10);

            }
        });

        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicnName = "python";
                python.setBackgroundResource(R.drawable.white_background_stroke);

                java.setBackgroundResource(R.drawable.round_back_10);
                webprog.setBackgroundResource(R.drawable.round_back_10);
                cplusplus.setBackgroundResource(R.drawable.round_back_10);

            }
        });

        webprog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicnName = "webprog";
                webprog.setBackgroundResource(R.drawable.white_background_stroke);

                python.setBackgroundResource(R.drawable.round_back_10);
                java.setBackgroundResource(R.drawable.round_back_10);
                cplusplus.setBackgroundResource(R.drawable.round_back_10);
            }
        });

        cplusplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopicnName = "cplusplus";
                cplusplus.setBackgroundResource(R.drawable.white_background_stroke);

                python.setBackgroundResource(R.drawable.round_back_10);
                webprog.setBackgroundResource(R.drawable.round_back_10);
                java.setBackgroundResource(R.drawable.round_back_10);
            }
        });

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedTopicnName.isEmpty()){
                    Toast.makeText(quiz_main.this, "Please Select a Topic", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(quiz_main.this,quiztopicSelected.class);
                    intent.putExtra("selectedTopic",selectedTopicnName);
                    startActivity(intent);
                }

            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}