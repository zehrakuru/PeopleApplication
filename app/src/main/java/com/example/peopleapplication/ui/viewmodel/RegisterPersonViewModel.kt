package com.example.peopleapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.peopleapplication.data.repo.PeopleDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterPersonViewModel @Inject constructor (var prepo:PeopleDaoRepository) : ViewModel() {

    fun register(person_name:String, person_phone:String) {
        prepo.personRegister(person_name,person_phone)
    }
}