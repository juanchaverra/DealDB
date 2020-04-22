package com.example.dealdb.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.dealdb.BR
import com.example.dealdb.R
import com.example.dealdb.model.Offer
import com.example.dealdb.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.deal_list_item.view.*

class DealsAdapter(var mainViewModel: MainViewModel):
    RecyclerView.Adapter<DealsAdapter.DealsViewHolder>() {

    private var dealsList: List<Offer>? = null



    fun setDealsList(deals: List<Offer>){
        this.dealsList = deals
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DealsViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding:ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return DealsViewHolder(binding)
    }


    override fun getItemCount(): Int = dealsList?.size ?: 0

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        holder.setDeal(mainViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.deal_list_item
    }

    class DealsViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    {

        private var binding: ViewDataBinding ? = null
        private var deal : Offer? = null

        init {
            this.binding = binding
        }

        fun setDeal(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
            this.deal = deal
        }

  /*      override fun onClick(v: View) {
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtra("cupon", deal)
            itemView.context.startActivity(intent)
        }
*/


    }

}


