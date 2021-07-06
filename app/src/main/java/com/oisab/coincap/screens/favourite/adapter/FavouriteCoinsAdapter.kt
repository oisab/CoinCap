package com.oisab.coincap.screens.favourite.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.oisab.coincap.R

class FavouriteCoinsAdapter: Adapter<FavouriteCoinsAdapter.FavouriteCoinViewHolder>() {
    private val coinItems: MutableList<FavouriteCoinCellModel> = ArrayList()

    fun setData(newCoinItems: ArrayList<FavouriteCoinCellModel>) {
        coinItems.clear()
        coinItems.addAll(newCoinItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteCoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavouriteCoinViewHolder(layoutInflater.inflate(R.layout.cell_favourite_coin, parent, false))
    }

    override fun onBindViewHolder(holder: FavouriteCoinViewHolder, position: Int) {
        holder.bind(coinItems[position])
    }

    override fun getItemCount(): Int {
        return coinItems.size
    }

    class FavouriteCoinViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(coinCellItem: FavouriteCoinCellModel) {
            val coinSymbol: AppCompatTextView = itemView.findViewById(R.id.favouriteCoinSymbol)
            val coinName: AppCompatTextView = itemView.findViewById(R.id.favouriteCoinName)
            val coinPrice: AppCompatTextView = itemView.findViewById(R.id.favouriteCoinPrice)
            val coinChangePercent: AppCompatTextView = itemView.findViewById(R.id.favouriteCoinChangePercent)

            coinSymbol.text = coinCellItem.coinSymbol
            coinName.text = coinCellItem.coinName
            coinPrice.text = coinCellItem.coinPriceUsd
            coinChangePercent.text = coinCellItem.coinChangePercent
        }
    }
}