package com.example.dealdb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dealdb.R
import com.example.dealdb.model.Offer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val cupon = intent?.getSerializableExtra("cupon") as Offer
        updateUI(cupon)
    }

    private fun updateUI(cupon: Offer){
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
    }
}
