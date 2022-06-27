package com.firstapp.applicationdev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class quiztopicSelected extends AppCompatActivity {

    private TextView questionCounts;
    private TextView questions;

    private AppCompatButton opt1, opt2, opt3, opt4;
    private AppCompatButton nextBtn;

    private Timer quizTimer;

    private int totalTimeinMins = 1;
    private int totalSeconds = 0;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    private List <QuestionList> questionLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiztopic_selected);

        final ImageView bckBtn = findViewById(R.id.bckBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicname);

        opt1 = findViewById(R.id.option1);
        opt2 = findViewById(R.id.option2);
        opt3 = findViewById(R.id.option3);
        opt4 = findViewById(R.id.option4);

        nextBtn = findViewById(R.id.nxtBtn);

        questionCounts = findViewById(R.id.questionCount);
        questions = findViewById(R.id.questions);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");
        selectedTopicName.setText(getSelectedTopicName);

        questionLists = QuestionBank.getQuestions(getSelectedTopicName);

        startTimer(timer);

        questionCounts.setText((currentQuestionPosition+1)+"/"+questionLists.size());
        questions.setText(questionLists.get(0).getQuestion());
        opt1.setText(questionLists.get(0).getOption1());
        opt2.setText(questionLists.get(0).getOption2());
        opt3.setText(questionLists.get(0).getOption3());
        opt4.setText(questionLists.get(0).getOption4());

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = opt1.getText().toString();
                    opt1.setBackgroundResource(R.drawable.round_back_red);
                    opt1.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }

            }
        });
        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = opt2.getText().toString();
                    opt2.setBackgroundResource(R.drawable.round_back_red);
                    opt2.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });
        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = opt3.getText().toString();
                    opt3.setBackgroundResource(R.drawable.round_back_red);
                    opt3.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }

            }
        });
        opt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    selectedOptionByUser = opt4.getText().toString();
                    opt4.setBackgroundResource(R.drawable.round_back_red);
                    opt4.setTextColor(Color.WHITE);

                    revealAnswer();
                    questionLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(quiztopicSelected.this, "Please Select an Option!", Toast.LENGTH_SHORT).show();
                }

                else{
                    changeNextQuestion();
                }
            }
        });

        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(quiztopicSelected.this, quiz_main.class));
                finish();

            }
        });


    }

    private void changeNextQuestion(){

        currentQuestionPosition++;

        if((currentQuestionPosition+1) == questionLists.size()){
            nextBtn.setText("Submit Quiz");
        }

        if((currentQuestionPosition) < questionLists.size()){
            selectedOptionByUser = "";

            opt1.setBackgroundResource(R.drawable.round_back_10);
            opt1.setTextColor(Color.parseColor("#1F6BB8"));

            opt2.setBackgroundResource(R.drawable.round_back_10);
            opt2.setTextColor(Color.parseColor("#1F6BB8"));

            opt3.setBackgroundResource(R.drawable.round_back_10);
            opt3.setTextColor(Color.parseColor("#1F6BB8"));

            opt4.setBackgroundResource(R.drawable.round_back_10);
            opt4.setTextColor(Color.parseColor("#1F6BB8"));

            questionCounts.setText((currentQuestionPosition+1)+"/"+questionLists.size());
            questions.setText(questionLists.get(currentQuestionPosition).getQuestion());
            opt1.setText(questionLists.get(currentQuestionPosition).getOption1());
            opt2.setText(questionLists.get(currentQuestionPosition).getOption2());
            opt3.setText(questionLists.get(currentQuestionPosition).getOption3());
            opt4.setText(questionLists.get(currentQuestionPosition).getOption4());
        }

        else{
            Intent intent = new Intent(quiztopicSelected.this,QuizResult.class);
            intent.putExtra("correct",getCorrectAnswer());
            intent.putExtra("incorrect",getInCorrectAnswer());
            startActivity(intent);
            finish();
        }

    }

    private void startTimer(TextView timerTextView){

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(totalSeconds == 0){
                    totalTimeinMins --;
                    totalSeconds = 59;
                }
                else if(totalSeconds ==0 && totalTimeinMins == 0){
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(quiztopicSelected.this, "Time's up !!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(quiztopicSelected.this, QuizResult.class);
                    intent.putExtra("correct",getCorrectAnswer());
                    intent.putExtra("Incorrect",getInCorrectAnswer());
                    startActivity(intent);

                    finish();
                }
                else{
                    totalSeconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTimeinMins);
                        String finalSeconds = String.valueOf(totalSeconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0"+finalMinutes;
                        }
                        if(finalSeconds.length() == 1){
                            finalSeconds = "0"+finalSeconds;
                        }

                        timerTextView.setText(finalMinutes+ ":"+finalSeconds);

                    }
                });

            }
        }, 1000, 1000);

    }

    private int getCorrectAnswer(){

        int correctAnswers = 0;

        for(int i = 0;i < questionLists.size();i++){
            final String getSelectedUserAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(getSelectedUserAnswer.equals(getAnswer)){
                correctAnswers++;

            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswer(){

        int correctAnswers = 0;

        for(int i = 0;i < questionLists.size();i++){
            final String getSelectedUserAnswer = questionLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionLists.get(i).getAnswer();

            if(!getSelectedUserAnswer.equals(getAnswer)){
                correctAnswers++;

            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(quiztopicSelected.this, quiz_main.class));
        finish();

    }

    private void revealAnswer()
    {
        final String getAnswer = questionLists.get(currentQuestionPosition).getAnswer();

        if(opt1.getText().toString().equals(getAnswer)){
            opt1.setBackgroundResource(R.drawable.round_back_green);
            opt1.setTextColor(Color.WHITE);
        }
        else if(opt2.getText().toString().equals(getAnswer)){
            opt2.setBackgroundResource(R.drawable.round_back_green);
            opt2.setTextColor(Color.WHITE);
        }
        else if(opt3.getText().toString().equals(getAnswer)){
            opt3.setBackgroundResource(R.drawable.round_back_green);
            opt3.setTextColor(Color.WHITE);
        }
        else if(opt4.getText().toString().equals(getAnswer)){
            opt4.setBackgroundResource(R.drawable.round_back_green);
            opt4.setTextColor(Color.WHITE);
        }
    }
}