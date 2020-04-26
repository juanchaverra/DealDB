package com.example.dealdb.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dealdb.model.Deals
import com.example.dealdb.model.MainObservable
import com.example.dealdb.model.Offer
import com.example.dealdb.view.DealsAdapter
import com.squareup.picasso.Picasso

class MainViewModel : ViewModel() {
    private var mainObservable: MainObservable = MainObservable()
    private var dealsAdapter: DealsAdapter ?= null
    private var dealSelected: MutableLiveData<Offer> = MutableLiveData()

    fun CallDeals(){
        mainObservable.callDeals()
    }

    fun getDeals() : MutableLiveData<List<Offer>>{
        return mainObservable.getDeals()
    }

    fun setDealsInDealsAdapter(deals: List<Offer>){
        dealsAdapter?.setDealsList(deals)
        dealsAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerDealsAdapter() : DealsAdapter?{
        dealsAdapter = DealsAdapter( this)
        return dealsAdapter

    }

    fun getDealsAt(position: Int): Offer?{
        var deal: List<Offer>? = mainObservable.getDeals().value
        return deal?.get(position)
    }

    fun getDealSelected() : MutableLiveData<Offer>{
        return dealSelected
    }

    fun onItemClick(position: Int) {
        val deal = getDealsAt(position)
        dealSelected.value = deal
    }

    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: ImageView, imageUrl:String){
            if(!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(imageView)
            }
        else{
            Picasso.get().load("https://img.icons8.com/dusk/64/000000/cutting-coupon.png").into(imageView)
            }
        }

    }
}