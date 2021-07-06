package com.oisab.coincap.screens.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oisab.coincap.R
import com.oisab.coincap.screens.news.adapter.NewsFragmentAdapter

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