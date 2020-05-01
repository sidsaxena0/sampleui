package com.sid.testapp.data


import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sid.testapp.model.Suggestion
import kotlinx.coroutines.delay
import java.lang.reflect.Type


object AccountRepository {
    private var questions = ArrayList<Suggestion>()


    operator fun invoke(context: Context): AccountRepository {
        // init the data source

        return this
    }

    suspend fun getSuggestions(): List<Suggestion>? {
        delay(1000)
        val listType: Type = object : TypeToken<List<Suggestion?>?>() {}.type
        val data: List<Suggestion> = Gson().fromJson(DummyData.data, listType)
        return data
    }

    suspend fun getSuggestionsById(id: Int): Suggestion? {
        delay(1000)
        val listType: Type = object : TypeToken<List<Suggestion?>?>() {}.type
        val data: List<Suggestion> = Gson().fromJson(DummyData.data, listType)
        val user: Suggestion = data.single { it.id == id }
        return user
    }



}