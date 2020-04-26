package com.example.dealdb.view

import android.content.Intent
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

        setUpListClick()
    }

    fun setUpListClick(){
        mainViewModel?.getDealSelected()?.observe(this, Observer{deal ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("cupon", deal)
            startActivity(intent)
        })
    }

}
