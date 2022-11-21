package com.rahul.retrofitapikotlinmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rahul.retrofitapikotlinmvvm.databinding.MovieLayoutBinding
import com.rahul.retrofitapikotlinmvvm.model.Article

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList = ArrayList<Article>()

    fun setMovieList(movieList: List<Article>) {
        this.movieList = movieList as ArrayList<Article>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(MovieLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView).load(movieList[position].urlToImage)
            .placeholder(R.drawable.ic_launcher_background).into(holder.binding.imgViewCover)
        holder.binding.tvTitle.text = movieList[position].title
        holder.binding.tvDescription.text = movieList[position].description
        holder.binding.tvAuthorAndPublishedAt.text = movieList[position].author
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}