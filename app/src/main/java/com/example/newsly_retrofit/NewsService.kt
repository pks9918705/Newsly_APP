package com.example.newsly_retrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.gson.GsonConverterFactory.*
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=

const val BASE_URL="https://newsapi.org/"
const val API_KEY="18690ece059a475d9b9f21a2a73f06d2"
interface NewsInterface {

    // there we will have how we are going to define all the fxn
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines( @Query("country") country:String, @Query("page") page:Int) :Call<News>

    /*
        this link is made by this function
        https://newsapi.org/v2/top-headlines?apiKey=18690ece059a475d9b9f21a2a73f06d2&country=in&page=1

         if this function is successful than it will call sucessfully callback

    */

}

// singleton
object NewsService{
    val newsInstance:NewsInterface
    init {
        // creating object of retrofit
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance=retrofit.create(NewsInterface::class.java)

    }
}