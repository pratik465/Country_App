package com.example.country_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.country_app.Adapter.Adapter_country
import com.example.country_app.Click.Click_Now
import com.example.country_app.Client.CountryClient
import com.example.country_app.Detail.Country_Details
import com.example.country_app.Intrface.CountryInterface
import com.example.country_app.Model.CountryModel
import com.example.country_app.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        var CountryData = ArrayList<CountryModel>()
    }

    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter_country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callApi()

    }

    private fun callApi() {

        var api = CountryClient.getApiClient()?.create(CountryInterface::class.java)
        api?.getCountry()?.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(
                call: Call<List<CountryModel>>,
                response: Response<List<CountryModel>>
            ) {

                CountryData = response.body() as ArrayList<CountryModel>

                if (response.isSuccessful) {

                    var clickNow = object : Click_Now{
                        override fun onclick(i: Int) {
                            var intent = Intent(this@MainActivity, Country_Details::class.java).putExtra("pos",i)
                            startActivity(intent)
                        }

                    }

                    binding.rcvflags.layoutManager = GridLayoutManager(this@MainActivity, 1)
                    binding.rcvflags.adapter = Adapter_country(CountryData,clickNow)

                }

            }

            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {

            }
        })

    }
}