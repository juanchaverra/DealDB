package com.example.dealdb.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dealdb.model.Offer
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetailViewModel : ViewModel() {

    private var deal: MutableLiveData<Offer> = MutableLiveData()

    fun setViews(deal: Offer) {
       this.deal.value = deal
    }

    fun getDeal() : MutableLiveData<Offer> = deal

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl:String){
            if(!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(imageView)
            }
            else{
                Picasso.get().load("https://img.icons8.com/dusk/64/000000/cutting-coupon.png").into(imageView)
            }
        }

    }


}