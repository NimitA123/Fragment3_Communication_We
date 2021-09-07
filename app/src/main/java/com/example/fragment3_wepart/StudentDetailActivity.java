package com.example.fragment3_wepart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class StudentDetailActivity extends AppCompatActivity implements CommunicationListener {
    private FragmentManager fragmentManager;

    /*** All the communication happen in  main Activity with the help of main Activity we can simply
     * send the data between fragment.can  not send data fragment to fragment because we are launching
     * fragment in the main Activity so
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*** fragmentManager will keep all the transaction  **/
        fragmentManager = getSupportFragmentManager();
        launchStudentPersonalDetailsFragment();
    }

    private void launchStudentPersonalDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPersonlDetailsFragment fragment = new StudentPersonlDetailsFragment();
        fragmentTransaction.add(R.id.container, fragment, "Personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StudentPerformanceDetailsFragment personalDetailsFragment = new StudentPerformanceDetailsFragment();
        /*To send data from one fragment to second fragment use setArgument and setArgument takes bundle parameter inside it */
        personalDetailsFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.container, personalDetailsFragment, "Personal").addToBackStack("Personal").commit();

    }
}