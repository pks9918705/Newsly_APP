package com.example.newsly_retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class NewsAdapter(val context: Context,val articles:List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {

        val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)

        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        // we can't bind image view directly
        // to get image and bind it we need to have a gridle library
        val article:Article=articles[position]
        holder.newsTitle.text=article.title
        holder.newsDescription.text=article.description

        // for image
        Glide.with(context).load(article.urlToImage).into(holder.newsImage)

        // clicking feature
        holder.itemView.setOnClickListener{
            Toast.makeText(context, article.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int { return articles.size

    }



    class ArticleViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        // here we are hold the refernces of our views so that we don't need to call "find.view.by id"
        var newsImage=itemView.newsImage
        var newsTitle=itemView.newsTitle
        var newsDescription=itemView.newsDescription
    }

}