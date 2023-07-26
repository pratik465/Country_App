package com.example.country_app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.country_app.Click.Click_Now
import com.example.country_app.Model.CountryModel
import com.example.country_app.databinding.FlagsBinding

class Adapter_country(countryModel: ArrayList<CountryModel>, clicknow: Click_Now) : RecyclerView.Adapter<Adapter_country.Countryholder>() {

    var list = countryModel
    lateinit var context: Context
    var Clicknow = clicknow

    class Countryholder(itemView: FlagsBinding) : RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Countryholder {
        context = parent.context
        var binding = FlagsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Countryholder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Countryholder, position: Int) {

        holder.binding.apply {
            list.get(position).apply {
                Glide.with(context).load(flags?.png).into(imgPhotos)
                txtName.text = name
                txtCapital.text = capital
                txtCode.text = callingCodes.toString()
                txtArea.text = area.toString()

                holder.itemView.setOnClickListener {
                    Clicknow.onclick(position)
                }

            }

        }

    }

}