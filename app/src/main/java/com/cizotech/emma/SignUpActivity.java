package com.cizotech.emma;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cizotech.emma.databinding.ActivitySigninBinding;
import com.cizotech.emma.databinding.ActivitySignupBinding;

/**
 * Created by Sai Infotech on 3/12/2018.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_signup);
        binding.textSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
        finish();
    }
}
