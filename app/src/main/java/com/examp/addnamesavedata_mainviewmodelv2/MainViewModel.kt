package com.examp.addnamesavedata_mainviewmodelv2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val names = MutableLiveData<List<String>>().apply { value = emptyList() }

    fun addName(name: String) {
        val currentList = names.value?.toMutableList() ?: mutableListOf()
        currentList.add(name)
        names.value = currentList
    }
}
