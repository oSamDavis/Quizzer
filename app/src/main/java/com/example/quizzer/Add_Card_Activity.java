package com.example.quizzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Add_Card_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__card_);


        findViewById(R.id.cancel_icon_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Send a RESULT_ERROR
            }
        });

        findViewById(R.id.save_icon_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get text from edit text
                String save_question =   ((EditText) findViewById(R.id.question_edit_text)).getText().toString();
                String save_answer = ((EditText) findViewById(R.id.answer_edit_text)).getText().toString();

                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("string1", save_question); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("string2", save_answer); // puts another string into the Intent, with the key as 'string2
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes this activity and pass data to the original activity that launched this activity
            }
        });
    }
}
