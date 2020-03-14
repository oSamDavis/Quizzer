package com.example.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean isShowingAnswer = true;
    FlashcardDatabase flashcardDatabase;
    List <Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        allFlashcards = flashcardDatabase.getAllCards();

        if(allFlashcards!= null && allFlashcards.size() > 0)
        {
            ((TextView) findViewById(R.id.quiz_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.quiz_answer)).setText(allFlashcards.get(0).getAnswer());

        }

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

        findViewById(R.id.add_icon_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Add_Card_Activity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

        findViewById(R.id.next_icon_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCardDisplayedIndex++;

                if(currentCardDisplayedIndex > allFlashcards.size() - 1){
                    currentCardDisplayedIndex = 0;
                }

                ((TextView) findViewById(R.id.quiz_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.quiz_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            // get data sent from add activity
            String s1 = data.getExtras().getString("string1");
            String s2 = data.getExtras().getString("string2");
            ((TextView) findViewById(R.id.quiz_question)).setText(s1);
            ((TextView) findViewById(R.id.quiz_answer)).setText(s2);
            flashcardDatabase.insertCard(new Flashcard(s1,s2));
            allFlashcards = flashcardDatabase.getAllCards();
        }

    }




}
