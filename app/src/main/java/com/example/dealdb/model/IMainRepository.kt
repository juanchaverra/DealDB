package com.example.dealdb.model

import androidx.lifecycle.MutableLiveData

interface IMainRepository {
    fun CallDealsAPI()
    fun getDeals(): MutableLiveData<List<Offer>>
}