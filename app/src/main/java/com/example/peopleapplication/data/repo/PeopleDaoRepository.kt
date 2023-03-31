package com.example.peopleapplication.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.peopleapplication.data.entity.People
import com.example.peopleapplication.room.PeopleDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleDaoRepository(var pdao:PeopleDao) {
    var peopleList:MutableLiveData<List<People>>

    init {
        peopleList = MutableLiveData()
    }

    fun getPeopleHere() : MutableLiveData<List<People>> {
        return peopleList
    }

    fun personRegister(person_name:String, person_phone:String) {
        Log.e("Person Register", "@$person_name - $person_phone")
    }

    fun personUpdate(person_id:Int, person_name:String, person_phone: String){
        Log.e("Person Update", "$person_id - $person_name - $person_phone")
    }

    fun searchPerson(searchWord:String) {
        Log.e("Search Word", searchWord)
    }

    fun deletePerson(person_id:Int) {
        Log.e("Delete person", person_id.toString())
    }

    fun getAllPeople() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            peopleList.value = pdao.getPeople()
        }
    }
}