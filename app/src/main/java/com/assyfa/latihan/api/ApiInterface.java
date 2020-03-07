package com.assyfa.latihan.api;

import com.assyfa.latihan.model.LoginRequest;
import com.assyfa.latihan.model.Response;
import com.assyfa.latihan.model.RegisterRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by eko.purnomo on 28/07/2017.
 * You can contact me at : ekosetyopurnomo@gmail.com
 * or for more detail at  : http://ekosp.com
 */

public interface ApiInterface {

    @POST("login.php")
    Observable<Response<Response>> lakukanLogin(@Body LoginRequest data);

    @POST("register.php")
    Observable<Response<Response>> lakukanRegister(@Body RegisterRequest data);


    @POST("rest-api/05_daftar_member.php")
    Observable<Response<Response>> doRegister(
            @Query("key") String key,
            @Query("nama_pelanggan") String nama_pelanggan,
            @Query("nomor_kontak") String nomor_kontak,
            @Query("email") String email,
            @Query("password") String password,
            @Query("daftar_warung") String daftar_warung,
            // jika buka warung
            @Query("nama_warung") String pemilik_warung,
            @Query("alamat_warung") String alamat_warung,
            @Query("nomor_rekening_bank") String no_rekening,
            @Query("nama_bank") String nama_bank,
            @Query("atas_nama_bank") String pemilik_rekening

    );
}