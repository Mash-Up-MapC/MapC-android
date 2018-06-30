package mashup.kr.mapc.api;

import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/test")
    Response<Void> test();

}
