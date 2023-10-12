package com.jpmc.jpmcschoolproject.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
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

public class SchoolNamesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SchoolNameAdapter schoolAdapter;
    ApiInterface apiInterface;
    List<SchoolNamesModel> schoolNamesModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_names);
        recyclerView=findViewById(R.id.recyclerSchool);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getSchoolnameData();
    }

    private void getSchoolnameData() {
        apiInterface= RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Call<List<SchoolNamesModel>> call=apiInterface.getSchollNames();
        call.enqueue(new Callback<List<SchoolNamesModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<SchoolNamesModel>> call, @NonNull Response<List<SchoolNamesModel>> response) {

                    if (response.isSuccessful() && response.body() != null) {
                        List<SchoolNamesModel> schoolDataList = response.body();
                        SchoolNameAdapter  schoolNameAdapter=new SchoolNameAdapter(SchoolNamesActivity.this,schoolDataList);
                        recyclerView.setAdapter(schoolNameAdapter);
                        if (!schoolDataList.isEmpty()) {
                            SchoolNamesModel schoolData = schoolDataList.get(0); // Get the first item
                          //  schoolNameTextView.setText("School Name: " + schoolData.getSchoolName());
                        } else {
                           // schoolNameTextView.setText("No data available.");
                        }
                    } else {
                       // schoolNameTextView.setText("Failed to retrieve data.");
                    }

                }
            @Override
            public void onFailure(@NonNull Call<List<SchoolNamesModel>> call,@NonNull Throwable t) {
                Toast.makeText(SchoolNamesActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
    }