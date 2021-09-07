package com.example.fragment3_wepart;

import android.content.Context;
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
 * Use the {@link StudentPersonlDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class StudentPersonlDetailsFragment extends Fragment {
    private Button MBtnText;
    private EditText mEtName;
    private EditText mEtAge;
    private CommunicationListener listener;


/*Can also use constructor for the communication listener*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_personl_details, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        /**W**/
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mEtName = view.findViewById(R.id.etStudentName);
        mEtAge = view.findViewById(R.id.etStudentAge);
        MBtnText = view.findViewById(R.id.btnNext);
        MBtnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEtName.getText().toString();
                int age = Integer.parseInt(mEtAge.getText().toString());
                /*Bundle is like a intent here */
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putInt("age", age);
                if(listener!=null){
                    listener.launchPerformanceFragment(bundle);
                }
            }
        });

    }
}