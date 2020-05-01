package com.sid.testapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sid.testapp.data.AccountRepository
import com.sid.testapp.model.Suggestion
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    val suggestions: MutableLiveData<List<Suggestion>> = MutableLiveData()
    val repository = AccountRepository(application.applicationContext)

    init {
        getData()
    }

    fun getData(){
        // Get data using coroutines
        viewModelScope.launch {
            suggestions.value = repository.getSuggestions()
        }

    }

}