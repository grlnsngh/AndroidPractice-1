package com.example.simranjeet.calculatorv1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ContainerActivity extends AppCompatActivity implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private String TAG = "ContainerActivity";

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        int count = fragmentManager.getBackStackEntryCount();

        Fragment fragment = fragmentManager.findFragmentByTag("TAG C");
        if (fragment instanceof FragmentC) {
            fragmentManager.popBackStack();
        }

        if (count == 0) {
            finish();
        } else {
            FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(count - 1);
            String name = entry.getName();
            Log.e(TAG, "onBackPressed Name : " + name + ", Count : " + count);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        TextView buttonA = (TextView) findViewById(R.id.buttonA);
        TextView buttonB = (TextView) findViewById(R.id.buttonB);
        TextView buttonC = (TextView) findViewById(R.id.buttonC);
        TextView buttonD = (TextView) findViewById(R.id.buttonD);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();

        loadFragment(new FragmentA(), "Fragment A", "TAG A");
    }

    public void loadFragment(Fragment fragment, String backStackName, String tagName) {
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        fragmentTransaction1.add(R.id.container, fragment, tagName)
                .addToBackStack(backStackName).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonA:
                loadFragment(new FragmentA(), "Fragment A", "TAG A");
                break;
            case R.id.buttonB:
                loadFragment(new FragmentB(), "Fragment B", "TAG B");
                break;
            case R.id.buttonC:
                loadFragment(new FragmentC(), "Fragment C", "TAG C");
                break;
            case R.id.buttonD:
                loadFragment(new FragmentD(), "Fragment D", "TAG D");
                break;
        }
    }
}
