package com.example.peopleapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.peopleapplication.R
import com.example.peopleapplication.databinding.FragmentPersonInfoBinding
import com.example.peopleapplication.ui.viewmodel.PersonInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonInfoFragment : Fragment() {

    private lateinit var design:FragmentPersonInfoBinding
    private lateinit var viewModel:PersonInfoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater, R.layout.fragment_person_info, container, false)
        design.personInfoFragment = this
        design.toolbarInfoTitle = "Information Page"

        val bundle:PersonInfoFragmentArgs by navArgs()
        val person = bundle.person

        design.personObject = person

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonInfoViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(person_id:Int, person_name:String, person_phone:String) {
        Log.e("Person Update", "$person_id - $person_name - $person_phone")
    }
}