package com.example.dealdb.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData


class MainObservable: BaseObservable() {
    private var mainRepository: IMainRepository = com.example.dealdb.model.MainRepository()

    fun callDeals(){
        mainRepository.CallDealsAPI()
    }

    fun getDeals() : MutableLiveData<List<Offer>>{
        return mainRepository.getDeals()
    }
 }