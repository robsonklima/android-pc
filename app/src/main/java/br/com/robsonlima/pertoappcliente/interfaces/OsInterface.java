package br.com.robsonlima.pertoappcliente.interfaces;

import br.com.robsonlima.pertoappcliente.models.Os;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OsInterface {

    @GET("/Os/6347555")
    Call<List<Os>> getListOss();

    @GET("/Os/?")
    Call<List<Os>> getPost(@Query("id") int id);

    @POST("/Os/")
    Call<Os> createPost(@Body Os post);

    @PUT("/Os/{id}")
    Call <Os> updatePost(@Path("id") int id, @Body Os post);

    @DELETE("/Os/{id}")
    Call <Os> deletePost(@Path("id") int id);
}
