package com.cizotech.emma;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cizotech.emma.databinding.ActivitySigninBinding;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySigninBinding binding;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_signin);
       binding.textLoginin.setOnClickListener(this);
        toolbar=findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(SignInActivity.this,HomeActivity.class));
        finish();
    }
}
