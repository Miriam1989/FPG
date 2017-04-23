package com.fpg.fpg.ws;

import com.fpg.fpg.models.OnBoarding;
import com.fpg.fpg.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jhovany on 15/04/17.
 */

public interface fpgClient {

    @GET(Constants.Host.HOME_SCRIPTS + Constants.Section.ONBOARGING + Constants.Script.JSON_ONBOARDING)
    Call<List<OnBoarding>> index();

}
