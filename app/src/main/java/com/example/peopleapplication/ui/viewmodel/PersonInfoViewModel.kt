package com.example.peopleapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.peopleapplication.data.repo.PeopleDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonInfoViewModel @Inject constructor (var prepo: PeopleDaoRepository) : ViewModel() {

    fun update(person_id:Int, person_name:String, person_phone: String){
        prepo.personUpdate(person_id,person_name,person_phone)
    }
}