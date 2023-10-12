package com.jpmc.jpmcschoolproject.Interface;

import com.jpmc.jpmcschoolproject.Model.SchoolNamesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("f9bf-2cp4.json")
    Call<List<SchoolNamesModel>> getSchollNames() ;
}
