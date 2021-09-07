package com.example.fragment3_wepart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    private TextView mTVName;
    private TextView mTVAge;
    private TextView mTVGrade;
    private TextView mTVPercentage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        mTVName.setText(model.getName());
        mTVAge.setText(model.getAge()+"");
        mTVGrade.setText(model.getGrade());
        mTVPercentage.setText(model.getPercentage());
    }

    private void initView() {
        mTVName = findViewById(R.id.tvStudentName);
        mTVAge = findViewById(R.id.tvStudentAge);
        mTVGrade = findViewById(R.id.tvStudentGrade);
        mTVPercentage = findViewById(R.id.tvStudentPercentage);

    }
}