package kr.mashup.mapc.api;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Api {

    private static final String SERVER_URL = "https://test.mashup.com/";
    private static ApiService apiService;

    public static ApiService getInstance() {
        if (apiService == null) {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .client(builder.build())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }


}
