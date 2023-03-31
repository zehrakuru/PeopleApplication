package com.example.peopleapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.peopleapplication.R
import com.example.peopleapplication.databinding.FragmentRegisterPersonBinding
import com.example.peopleapplication.ui.viewmodel.RegisterPersonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterPersonFragment : Fragment() {

    private lateinit var design:FragmentRegisterPersonBinding
    private lateinit var viewModel:RegisterPersonViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_register_person, container, false)
        design.registerPersonFragment = this
        design.toolbarRegisterTitle = "Register Page"

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : RegisterPersonViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonRegister(person_name:String, person_phone:String) {
        viewModel.register(person_name, person_phone)
    }
}