package com.example.country_app.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryClient {
    companion object {

        val BASE_URL = "https://restcountries.com/v2/"
        var retrofit: Retrofit? = null

        fun getApiClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    }
}
