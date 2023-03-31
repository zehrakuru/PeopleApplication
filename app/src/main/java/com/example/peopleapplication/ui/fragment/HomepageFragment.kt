package com.example.peopleapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.fragment.app.viewModels
import com.example.peopleapplication.R
import com.example.peopleapplication.data.entity.People
import com.example.peopleapplication.databinding.FragmentHomepageBinding
import com.example.peopleapplication.ui.adapter.PeopleAdapter
import com.example.peopleapplication.ui.viewmodel.HomepageViewModel
import com.example.peopleapplication.util.doTransition
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var design:FragmentHomepageBinding
    private lateinit var viewModel:HomepageViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)
        design.homepageFragment = this
        design.toolbarHomepageTitle = "People"
        (activity as AppCompatActivity).setSupportActionBar(design.toolbarHomepage)

        viewModel.peopleList.observe(viewLifecycleOwner){
            val adapter = PeopleAdapter(requireContext(), it, viewModel)
            design.peopleAdapter = adapter
        }


        requireActivity().addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu)

                val item = menu.findItem(R.id.action_search)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomepageFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomepageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View) {
        Navigation.doTransition(it, R.id.registerPersonTransition)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
    }
}