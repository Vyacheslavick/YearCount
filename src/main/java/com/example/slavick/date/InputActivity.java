package com.example.slavick.date;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputActivity extends AppCompatActivity {
    public static final String KEY = "key";
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.day)
    EditText day;
    @BindView(R.id.month)
    EditText month;
    @BindView(R.id.year)
    EditText year;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.next)
    public void onClick(){
        Intent intent = new Intent(this, DataActivity.class);
        user = new User(day.getText().toString(), month.getText().toString(), year.getText().toString());
        intent.putExtra(KEY, user);
        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY , user);

    }
}
