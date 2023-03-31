package com.example.peopleapplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.peopleapplication.data.entity.People
import com.example.peopleapplication.data.repo.PeopleDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(var prepo:PeopleDaoRepository) : ViewModel() {
    var peopleList = MutableLiveData<List<People>>()

    init{
        getPeople()
        peopleList = prepo.getPeopleHere()
    }

    fun search(searchWord:String) {
        prepo.searchPerson(searchWord)
    }

    fun delete(person_id:Int) {
        prepo.deletePerson(person_id)
    }

    fun getPeople() {
        prepo.getAllPeople()
    }
}