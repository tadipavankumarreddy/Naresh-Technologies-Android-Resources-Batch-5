package in.nareshtechnologies.fruityviceretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FruitService {

    @GET("all")
    Call<List<Datum>> getFruitsData();
}
