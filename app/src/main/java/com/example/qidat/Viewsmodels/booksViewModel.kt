package com.example.qidat.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.qidat.Domain.repository
import com.example.qidat.Models.books

class booksViewModel:ViewModel() {
    val repository= repository()
    fun fetchBookData():LiveData<MutableList<books>>{
        val mutableData= MutableLiveData<MutableList<books>>()
        repository.getBooksData().observeForever {
            mutableData.value = it
        }
        return mutableData
    }
}