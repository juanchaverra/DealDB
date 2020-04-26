package com.example.dealdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dealdb.R
import com.example.dealdb.databinding.ActivityDetailBinding
import com.example.dealdb.model.Offer
import com.example.dealdb.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private var detailViewModel: DetailViewModel ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setupBindings(savedInstanceState)
    }
    private fun setupBindings(savedInstanceState: Bundle?){
        var activityDetailBinding : ActivityDetailBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_detail)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        activityDetailBinding.model = detailViewModel
        activityDetailBinding.lifecycleOwner = this

        detailViewModel?.setViews(intent?.getSerializableExtra("cupon") as Offer)
    }

    /*private fun updateUI(cupon: Offer){
        val URL_IMAGE_DEFECT = "https://img.icons8.com/dusk/64/000000/cutting-coupon.png"
        tv_title.text = cupon.title
        tv_store2.text = cupon.store
        tv_end_date.text = cupon.endDate
        tv_start_date.text = cupon.startDate
        tv_description.text = cupon.description
        if(!cupon.imageUrl.isNullOrEmpty()){
            Picasso.get().load(cupon.imageUrl).into(iv_picture2)
        }
        else{
            Picasso.get().load(URL_IMAGE_DEFECT).into(iv_picture2)
        }
    }*/
}
