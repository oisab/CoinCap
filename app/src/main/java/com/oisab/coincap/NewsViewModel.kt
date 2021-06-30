package com.oisab.coincap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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