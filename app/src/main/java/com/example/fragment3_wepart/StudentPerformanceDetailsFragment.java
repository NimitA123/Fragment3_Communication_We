package com.example.fragment3_wepart;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentPerformanceDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentPerformanceDetailsFragment extends Fragment {
    private EditText mEtGrade;
    private EditText mEtPercentages;
    private Button mBtnPreView;
    private String name;
    private int age;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name");
            age = getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_performance_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mEtGrade= view.findViewById(R.id.etStudentGrade);
        mEtPercentages = view.findViewById(R.id.etStudentPercentage);
        mBtnPreView = view.findViewById(R.id.btnPreview);
        mBtnPreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String grade = mEtGrade.getText().toString();
                String percentage = mEtPercentages.getText().toString();
                Model model = new Model(name, age, grade, percentage);
                Intent intent = new Intent(getContext(), PreviewActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);


            }
        });

    }
}