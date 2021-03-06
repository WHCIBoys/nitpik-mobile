package me.nitpik.nitpik_android.api;

import java.util.List;

import me.nitpik.nitpik_android.models.Friendship;
import me.nitpik.nitpik_android.models.Nit;
import me.nitpik.nitpik_android.models.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Maaz on 2016-04-18.
 */
public interface APIService {
    @POST("token-grant")
    Call<Token> grantToken(@Query("access_token") String accessToken);

    @GET("friendships")
    Call<List<Friendship>> getFriendships();

//    @GET("friendships/{id}")
//    Call<Friendship> getFriendship(@Path("id") String friendshipId);

    @GET("nits")
    Call<List<Nit>> getNits(@Query("authorId") String authorId, @Query("userId") String userId);

    @POST("nits")
    Call<Nit> createNit(@Body Nit nit);
}
