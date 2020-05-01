package com.sid.testapp.ui


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sid.testapp.data.AccountRepository
import com.sid.testapp.model.Suggestion
import kotlinx.coroutines.launch


class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    val suggestion: MutableLiveData<Suggestion> = MutableLiveData()
    val inProgress: MutableLiveData<Boolean> = MutableLiveData()
    val repository = AccountRepository(application.applicationContext)

    init {
    }

    fun getData(id: Int){
        // Get data using coroutines
        viewModelScope.launch {
            inProgress.value = true
            suggestion.value = repository.getSuggestionsById(id)
            inProgress.value = false
        }

    }

}