package com.example.sharedviewmodeldemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharedviewmodeldemo.model.Message

class SharedViewModel : ViewModel() {
    val urlLiveData = MutableLiveData<String>()

    fun setUrl(url: Message) {
        urlLiveData.value = url.dataMessage
    }
}