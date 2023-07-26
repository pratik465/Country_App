package com.example.country_app.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.country_app.MainActivity
import com.example.country_app.databinding.CoutryDetailsBinding

class Country_Details : AppCompatActivity() {
    lateinit var binding: CoutryDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = CoutryDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var pos = intent.getIntExtra("pos",0)
        var model = MainActivity.CountryData(pos)

        Glide.with(this).load(model.flags.png).into(binding.imgFlag)
        binding.txtIndia.text = model.name
        binding.txtCapital.text = model.capital
        binding.txtCountryCode.text = model.callingCodes.toString()
        binding.txtAllArea.text = model.area.toString()
        binding.txtLanguage.text = model.languages.toString()
        binding.txtPopulation.text = model.population.toString()
        binding.txtTimezone.text = model.timezones.toString()
        binding.txtCurrencies.text = model.currencies.toString()

    }
}