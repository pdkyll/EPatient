package com.example11.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import com.example11.adapters.AnimAdapterUtil;
import com.example11.fragments.Fragment_Verify_pwd;

public class RegisteActivity extends FragmentActivity implements Fragment_Verify_pwd.GetType{

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_layout);

        context = this;

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(getSupportFragmentManager().getBackStackEntryCount()==0){
                finish();
                AnimAdapterUtil.anim_translate_back(context);
                return true;
            }
        }
        return true;
    }


    @Override
    public int getType() {
        return getIntent().getIntExtra("type",0);
    }
}
