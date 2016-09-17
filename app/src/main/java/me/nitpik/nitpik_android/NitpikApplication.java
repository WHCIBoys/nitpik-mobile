package me.nitpik.nitpik_android;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.MaterialModule;

import java.util.List;

import me.nitpik.nitpik_android.api.APIService;
import me.nitpik.nitpik_android.models.Friendship;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maazali on 2016-09-17.
 */
public class NitpikApplication extends Application {
    private APIService apiService;

    // TODO: Use a hashmap of <friendshipId => Friendship> to make it easier
    // to potentially update friendship cache at a later date.
    List<Friendship> friendships;

    public void onCreate() {
        super.onCreate();
        Iconify.with(new MaterialModule());

        Stetho.initializeWithDefaults(this);

        FacebookSdk.sdkInitialize(getApplicationContext());

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(APIService.class);
    }

    public APIService getAPIService() {
        return apiService;
    }

    public List<Friendship> getFriendships() {
        return friendships;
    }

    public void setFriendships(List<Friendship> friendships) {
        this.friendships = friendships;
    }
}


