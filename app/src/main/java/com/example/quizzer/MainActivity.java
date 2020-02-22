package com.example.quizzer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean isShowingAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.quiz_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.quiz_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.quiz_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.first_option).setVisibility(View.INVISIBLE);
                findViewById(R.id.second_option).setVisibility(View.INVISIBLE);
                findViewById(R.id.third_option).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.quiz_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.quiz_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.quiz_question).setVisibility(View.VISIBLE);
                findViewById(R.id.first_option).setVisibility(View.VISIBLE);
                findViewById(R.id.second_option).setVisibility(View.VISIBLE);
                findViewById(R.id.third_option).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.first_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.first_option).setBackgroundColor(getResources().getColor(R.color.my_red_color,null));
                findViewById(R.id.second_option).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.second_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.second_option).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.third_option).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.third_option).setBackgroundColor(getResources().getColor(R.color.my_red_color, null));
                findViewById(R.id.second_option).setBackgroundColor(getResources().getColor(R.color.my_green_color, null));
            }
        });

        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.first_option).setBackground(getDrawable(R.drawable.option_background));
                findViewById(R.id.second_option).setBackground(getDrawable(R.drawable.option_background));
                findViewById(R.id.third_option).setBackground(getDrawable(R.drawable.option_background));
                findViewById(R.id.quiz_question).setVisibility(View.VISIBLE);
                findViewById(R.id.quiz_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.first_option).setVisibility(View.VISIBLE);
                findViewById(R.id.second_option).setVisibility(View.VISIBLE);
                findViewById(R.id.third_option).setVisibility(View.VISIBLE);

            }
        });


        findViewById(R.id.toggle_visibility).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(isShowingAnswer)
                {
                    //isShowingAnswer = false;
                    findViewById(R.id.first_option).setVisibility(View.INVISIBLE);
                    findViewById(R.id.second_option).setVisibility(View.INVISIBLE);
                    findViewById(R.id.third_option).setVisibility(View.INVISIBLE);
                    ((ImageView) findViewById(R.id.toggle_visibility)).setImageResource(R.drawable.ic_view_eye);

                }
                else

                    {
                        findViewById(R.id.first_option).setVisibility(View.VISIBLE);
                        findViewById(R.id.second_option).setVisibility(View.VISIBLE);
                        findViewById(R.id.third_option).setVisibility(View.VISIBLE);
                        ((ImageView) findViewById(R.id.toggle_visibility)).setImageResource(R.drawable.ic_unview_eye);
                        //isShowingAnswer = true;
                    }

                isShowingAnswer = !isShowingAnswer;


            }
        });


    }
}
