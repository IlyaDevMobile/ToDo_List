package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class create_list_add extends AppCompatActivity {

    private EditText input_text;
    private RadioButton low_priority;
    private RadioButton midl_priority;
    private Button Buttoncase;

    private AddNoteViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list_add);
        viewModel = new ViewModelProvider(this).get(AddNoteViewModel.class);
        viewModel.getShoudCloseScreen().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean shoudClose) {
                if (shoudClose){
                    finish();
                }

            }
        });
        initViews();
        Buttoncase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();

            }
        });
    }

    private void initViews() {
        input_text = findViewById(R.id.input_text);
        low_priority = findViewById(R.id.low_priority);
        midl_priority = findViewById(R.id.midl_priority);
        Buttoncase = findViewById(R.id.Buttoncase);


    }

    private void saveNote() {
        String text = input_text.getText().toString().trim();
        int priority = getProority();
        Note note = new Note(text, priority);
        viewModel.saveNote(note);

    }

    private int getProority() {
        int priority;
        if (low_priority.isChecked()) {
            priority = 0;
        } else if (midl_priority.isChecked()) {
            priority = 1;
        } else {
            priority = 2;
        }
        return priority;

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, create_list_add.class);

    }
}