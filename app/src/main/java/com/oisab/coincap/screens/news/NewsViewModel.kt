package com.oisab.coincap.screens.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oisab.coincap.R
import com.oisab.coincap.screens.news.adapter.CellNews

class NewsViewModel: ViewModel() {
    val newsItems = MutableLiveData<ArrayList<CellNews>>()

    fun generateNewsData() {
        newsItems.postValue(ArrayList<CellNews>().apply {
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
            add(CellNews(R.drawable.ic_launcher_foreground, "Биткоин вырос"))
        })
    }



}