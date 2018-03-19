package com.cizotech.emma;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cizotech.emma.databinding.ActivityLeaveInTreatmentBinding;
import com.cizotech.emma.pojo.HairePojo;

import java.util.ArrayList;
/**
 * Created by Sai Infotech on 3/13/2018.
 */



public class LeaveInTreatmentActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityLeaveInTreatmentBinding binding;
    ArrayList<HairePojo> hairePojos=new ArrayList<>();
    HairstyleAdapter hairstyleAdapter;
    boolean isSelected=false;
    int itemPosition=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_leave_in_treatment);
        hairstyleAdapter=new HairstyleAdapter(this,hairePojos);
        binding.rcHairestyle.setLayoutManager(new GridLayoutManager(this, 3));
        binding.rcHairestyle.setAdapter(hairstyleAdapter);

        hairePojos.add(new HairePojo("DETANGLING","",false));
        hairePojos.add(new HairePojo("HEAT PROTECTING","",false));
        hairePojos.add(new HairePojo("COLOR PROTECTING","",false));
        hairePojos.add(new HairePojo("SHINE ENHANCING","",false));
        hairePojos.add(new HairePojo("PARABEN FREE","",false));

        hairstyleAdapter.notifyDataSetChanged();
        binding.rcHairestyle.scrollToPosition(0);
        binding.textNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(LeaveInTreatmentActivity.this,StylingProductActivity.class));
    }


    public class HairstyleAdapter extends RecyclerView.Adapter<HairstyleAdapter.ViewHolder>{
        private Context context;
        ArrayList<HairePojo> data;

        public HairstyleAdapter(Context context, ArrayList<HairePojo> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public HairstyleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HairstyleAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chemical,parent,false));
        }

        @Override
        public void onBindViewHolder(HairstyleAdapter.ViewHolder holder, int position) {
            holder.title.setText(data.get(position).getTitle());
            if(data.get(position).isSelected())
            {
                holder.imgSelected.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.imgSelected.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            RelativeLayout rl_haire_container;
            ImageView imgSelected;
            public TextView title;
            public ViewHolder(View itemView) {
                super(itemView);
                imgSelected=itemView.findViewById(R.id.img_selected);
                title=itemView.findViewById(R.id.title);
                rl_haire_container=itemView.findViewById(R.id.rl_haire_container);
                rl_haire_container.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.rl_haire_container:
                        if(isSelected)
                        {
                            data.get(itemPosition).setSelected(false);
                            data.get(getLayoutPosition()).setSelected(true);
                            notifyItemChanged(itemPosition);
                            notifyItemChanged(getLayoutPosition());
                            itemPosition=getLayoutPosition();
                        }
                        else
                        {
                            data.get(getLayoutPosition()).setSelected(true);
                            notifyItemChanged(getLayoutPosition());
                            itemPosition=getLayoutPosition();
                            isSelected=true;
                        }

                        break;
                }
            }
        }
    }

}