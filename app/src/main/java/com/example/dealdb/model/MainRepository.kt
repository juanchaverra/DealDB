package com.example.dealdb.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.dealdb.model.server.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository: IMainRepository{
    private var deals = MutableLiveData<List<Offer>>()

    override fun getDeals():MutableLiveData<List<Offer>>{
        return deals }


    override fun CallDealsAPI() {
        val apikey = "76e0808fb145103cc0be319c505340bb"
        var dealsList: ArrayList<Offer>? = ArrayList()

        ApiService.create()
            .getDeal(apikey)
            .enqueue(object : Callback<Deals> {
                override fun onFailure(call: Call<Deals>, t: Throwable) {
                    Log.e("Error", t.message)
                }

                override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                    if (response.isSuccessful) {
                        dealsList = response.body()?.offers as ArrayList<Offer>
                    }
                    deals.value = dealsList
                }

            })
    }
}

