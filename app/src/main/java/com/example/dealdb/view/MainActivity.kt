package com.example.dealdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dealdb.R
import com.example.dealdb.databinding.ActivityMainBinding
import com.example.dealdb.model.Deals
import com.example.dealdb.model.Offer
import com.example.dealdb.model.server.ApiService
import com.example.dealdb.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var mainViewModel: MainViewModel ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBindings(savedInstanceState)
    }

    private fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.model = mainViewModel

        setUpListUpdate()
    }

    private fun setUpListUpdate() {
        mainViewModel?.CallDeals()

        mainViewModel?.getDeals()?.observe(this, Observer {
            Log.d("Deal", it.get(0).title)
            mainViewModel?.setDealsInDealsAdapter(it)
        })
    }
/*
    fun showErrorMsg(message: String?){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showDealList(dealList: ArrayList<Offer>){
        rv_deals.adapter = DealsAdapter(dealList)
    }


  private fun loadList() {
      val apiKey = "76e0808fb145103cc0be319c505340bb"

      ApiService.create()
          .getDeal(apiKey)
          .enqueue(object : Callback<Deals>{
              override fun onFailure(call: Call<Deals>, t: Throwable) {
                  Log.d("Error", t.message)
              }

              override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                  if (response.isSuccessful){
                      listDeals = response.body()?.offers as ArrayList<Offer>
                      val dealsAdapter = DealsAdapter(listDeals)
                      rv_deals.adapter = dealsAdapter
                  }
              }
          })
  }*/
}
