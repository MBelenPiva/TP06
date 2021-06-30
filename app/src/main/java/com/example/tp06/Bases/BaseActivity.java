package com.example.tp06.Bases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    public void goToFragmentWithAdd(int intContainerId, Fragment fragment, Boolean addBackStack){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        String strTAG;

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(addBackStack){
            strTAG = fragment.getClass().getName();
            fragmentTransaction.add(intContainerId, fragment, strTAG);
            fragmentTransaction.addToBackStack(strTAG);
        }else{
            fragmentTransaction.replace(intContainerId, fragment);
        }

        fragmentTransaction.commit();
    }

    public void goToFragmentWithReplace(int intContainerId, Fragment fragment, Boolean addBackStack){
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        String strTAG;

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        if(addBackStack){
            strTAG = fragment.getClass().getName();
            fragmentTransaction.replace(intContainerId, fragment, strTAG);
            fragmentTransaction.addToBackStack(strTAG);
        }else{
            fragmentTransaction.replace(intContainerId, fragment);
        }
        fragmentTransaction.commit();
    }
}
