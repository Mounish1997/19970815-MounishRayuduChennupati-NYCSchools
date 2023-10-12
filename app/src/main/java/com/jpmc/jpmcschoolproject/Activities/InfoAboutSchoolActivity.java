package com.jpmc.jpmcschoolproject.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.jpmc.jpmcschoolproject.Adapter.SchoolNameAdapter;
import com.jpmc.jpmcschoolproject.Interface.ApiInterface;
import com.jpmc.jpmcschoolproject.Model.SchoolNamesModel;
import com.jpmc.jpmcschoolproject.R;
import com.jpmc.jpmcschoolproject.Utils.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoAboutSchoolActivity extends AppCompatActivity {
    TextView DBNName, schoolName, num_of_sat_test_takersName, sat_critical_reading_avg_scorName, sat_math_avg_scoreName, sat_writing_avg_scoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_about_school);
        DBNName = findViewById(R.id.DBNName);
        schoolName = findViewById(R.id.schoolName);
        num_of_sat_test_takersName = findViewById(R.id.num_of_sat_test_takersName);
        sat_critical_reading_avg_scorName = findViewById(R.id.sat_critical_reading_avg_scorName);
        sat_math_avg_scoreName = findViewById(R.id.sat_math_avg_scoreName);
        sat_writing_avg_scoreName = findViewById(R.id.sat_writing_avg_scoreName);
        String schoolname = getIntent().getStringExtra("schoolname");
        String dbn = getIntent().getStringExtra("dbnName");
        String num_of_sat_test_takers = getIntent().getStringExtra("num_of_sat_test_takers");
        String sat_critical_reading_avg_score = getIntent().getStringExtra("sat_critical_reading_avg_score");
        String sat_math_avg_score = getIntent().getStringExtra("sat_math_avg_score");
        String sat_writing_avg_score = getIntent().getStringExtra("sat_writing_avg_score");
        schoolName.setText(schoolname);
        DBNName.setText(dbn);
        num_of_sat_test_takersName.setText(num_of_sat_test_takers);
        sat_critical_reading_avg_scorName.setText(sat_critical_reading_avg_score);
        sat_math_avg_scoreName.setText(sat_math_avg_score);
        sat_writing_avg_scoreName.setText(sat_writing_avg_score);


    }

}