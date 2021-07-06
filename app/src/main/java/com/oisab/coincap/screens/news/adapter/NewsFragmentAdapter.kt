package com.oisab.coincap.screens.news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.oisab.coincap.R

class NewsFragmentAdapter(
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<NewsFragmentAdapter.NewsViewHolder>() {
    private val newsItems: MutableList<CellNews> = ArrayList()

    fun setData(data: ArrayList<CellNews>) {
        newsItems.clear()
        newsItems.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(layoutInflater.inflate(R.layout.cell_news, parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val cellImage: AppCompatImageView = itemView.findViewById(R.id.cellNewsImage)
        private val cellText: AppCompatTextView = itemView.findViewById(R.id.cellNewsText)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(cell: CellNews) {
            if (cell.newsImage > 0) {
                cellImage.setImageResource(cell.newsImage)
            }
            cellText.text = cell.newsText
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}