package com.jpmc.jpmcschoolproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jpmc.jpmcschoolproject.Activities.InfoAboutSchoolActivity;
import com.jpmc.jpmcschoolproject.Model.SchoolNamesModel;
import com.jpmc.jpmcschoolproject.R;

import java.util.ConcurrentModificationException;
import java.util.List;

public class SchoolNameAdapter extends RecyclerView.Adapter<SchoolNameAdapter.ViewHolder> {
    private List<SchoolNamesModel> schools;
Context context;
    public SchoolNameAdapter(Context context,List<SchoolNamesModel> schools) {
        this.schools = schools;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_school_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        SchoolNamesModel schoolNamesModel = schools.get(position);
        holder.schoolNameTextView.setText(schoolNamesModel.getSchool_name());
        String dbnName=schoolNamesModel.getDbn();
        String school_name=schoolNamesModel.getSchool_name();
        String num_of_sat_test_takers=schoolNamesModel.getNum_of_sat_test_takers();
        String sat_critical_reading_avg_score=schoolNamesModel.getSat_critical_reading_avg_score();
        String sat_math_avg_score=schoolNamesModel.getSat_math_avg_score();
        String sat_writing_avg_score=schoolNamesModel.getSat_writing_avg_score();

        holder.schoolNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SchoolNamesModel selectedSchool = schools.get(position);
                Intent intent=new Intent(context, InfoAboutSchoolActivity.class);
                intent.putExtra("schoolname", school_name);
                intent.putExtra("dbnName", dbnName);
                intent.putExtra("num_of_sat_test_takers", num_of_sat_test_takers);
                intent.putExtra("sat_critical_reading_avg_score", sat_critical_reading_avg_score);
                intent.putExtra("sat_math_avg_score", sat_math_avg_score);
                intent.putExtra("sat_writing_avg_score", sat_writing_avg_score);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView schoolNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            schoolNameTextView = itemView.findViewById(R.id.schoolNameTextView);
        }
    }
}
