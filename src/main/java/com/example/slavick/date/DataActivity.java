package com.example.slavick.date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView data;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        ButterKnife.bind(this);

        user = getIntent().getParcelableExtra(InputActivity.KEY);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String date1 = data.toString();
        String d = user.day.concat(".");
        String a = d.concat(user.month);
        String t = a.concat(".");
        String date2 = t.concat(user.year);
        Date dateOne = null;
        Date dateTwo = null;
        try {
            dateOne = format.parse(date1);
            dateTwo = format.parse(date2);
        }catch (Exception e){
            e.printStackTrace();
        }

        long difference = dateOne.getTime() - dateTwo.getTime();
        data.setText((String.format("ВЫ прожили %d секунд", difference/1000)));
        data.setText(String.format("вы прожили %d дней", difference/1000/3600/24 ));
        int years =  (int)(difference / (365 * 24 * 60 * 60 * 1000));
        data.setText(String.format("Вам %d лет", years));
    }

}
