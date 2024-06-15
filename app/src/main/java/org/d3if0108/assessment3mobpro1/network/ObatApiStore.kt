package org.d3if0108.assessment3mobpro1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0108.assessment3mobpro1.model.OpStatus
import org.d3if0108.assessment3mobpro1.model.Obat
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://dianne.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ObatApiService {
    @GET("json.php")
    suspend fun getObat(
        @Query("auth") userId: String
    ): List<Obat>

    @Multipart
    @POST("json.php")
    suspend fun postObat(
        @Part("auth") userId: String,
        @Part("nama") nama: RequestBody,
        @Part("indikasi") indikasi: RequestBody,
        @Part("frekuensi") frekuensi: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("json.php")
    suspend fun deleteObat(
        @Query("auth") userId: String,
        @Query("id") id: String
    ): OpStatus
}

object ObatApi {
    val service: ObatApiService by lazy {
        retrofit.create(ObatApiService::class.java)
    }
    fun getObatUrl(gambar: String): String {
        return "$BASE_URL$gambar"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }