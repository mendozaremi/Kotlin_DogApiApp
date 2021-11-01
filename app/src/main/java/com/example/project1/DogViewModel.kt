package com.example.project1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project1.network.DogPhotoApi
import kotlinx.coroutines.launch


class DogViewModel : ViewModel() {
    private val _dogPhoto = MutableLiveData<`DogPhoto.kt`>()
    val dogPhoto: LiveData<`DogPhoto.kt`> = _dogPhoto

    init {
        getNewPhoto()
    }
    fun getNewPhoto(){
        viewModelScope.launch {
            _dogPhoto.value = DogPhotoApi.retrofitService.getRandomPhoto()
        }
    }
}