package com.cizotech.emma;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;


import com.cizotech.emma.databinding.ActivityHomeBinding;

/**
 * Created by Sai Infotech on 3/12/2018.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityHomeBinding binding;
    boolean isCollepse=false;
    Toolbar toolbar;
    AppCompatTextView textScaner,textList,textProfile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_home);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textScaner= toolbar.findViewById(R.id.act_scaner);
        textList= toolbar.findViewById(R.id.act_list);
        textProfile= toolbar.findViewById(R.id.act_profile);

        textScaner.setVisibility(View.VISIBLE);
        textList.setVisibility(View.VISIBLE);
        textProfile.setVisibility(View.VISIBLE);

        binding.rlProductPre.setOnClickListener(this);
        binding.textStyler.setOnClickListener(this);
        binding.textSempoo.setOnClickListener(this);
        binding.textRinseOut.setOnClickListener(this);
        binding.textLeaveIn.setOnClickListener(this);
        binding.textUpdatePreferece.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.rl_product_pre:
                checkCollepse();
                break;
            case R.id.img_topdwn:
                checkCollepse();
                break;
            case R.id.text_sempoo:
                changeBackground(binding.textSempoo);
                break;
            case R.id.text_rinse_out:
                changeBackground(binding.textRinseOut);
                break;
            case R.id.text_leave_in:
                changeBackground(binding.textLeaveIn);
                break;
            case R.id.text_styler:
                changeBackground(binding.textStyler);
                break;
            case R.id.text_update_preferece:
                startActivity(new Intent(HomeActivity.this,HairstyleActivity.class));
                finish();
                break;
        }
    }
    public void changeBackground(TextView view)
    {
        binding.textUpdatePreferece.setVisibility(View.VISIBLE);
        binding.textLeaveIn.setBackgroundResource(R.color.colorPrimary);
        binding.textRinseOut.setBackgroundResource(R.color.colorPrimary);
        binding.textSempoo.setBackgroundResource(R.color.colorPrimary);
        binding.textStyler.setBackgroundResource(R.color.colorPrimary);
        view.setBackgroundResource(R.color.colorAccent);

    }
    public void checkCollepse()
    {
        if(!isCollepse)
        {
            binding.linProductContainer.setVisibility(View.VISIBLE);
            isCollepse=true;
        }
        else
        {
            binding.linProductContainer.setVisibility(View.GONE);
            binding.textUpdatePreferece.setVisibility(View.GONE);
            binding.textLeaveIn.setBackgroundResource(R.color.colorPrimary);
            binding.textRinseOut.setBackgroundResource(R.color.colorPrimary);
            binding.textSempoo.setBackgroundResource(R.color.colorPrimary);
            binding.textStyler.setBackgroundResource(R.color.colorPrimary);
            isCollepse=false;
        }
    }
}
