package com.oisab.coincap

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsFragment : Fragment(R.layout.fragment_news), NewsFragmentAdapter.OnItemClickListener {
    private val newsAdapter = NewsFragmentAdapter(this)
    private var newsViewModel = NewsViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsRecyclerView: RecyclerView = view.findViewById(R.id.newsRecyclerView)
        newsRecyclerView.adapter = this.newsAdapter
        newsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        newsViewModel.generateNewsData()

        newsViewModel.newsItems.observe(viewLifecycleOwner, {
            newsAdapter.setData(it)
        })
    }

    override fun onItemClick(position: Int) {
        findNavController().navigate(R.id.action_newsFragment_to_newsItemFragment)
    }
}