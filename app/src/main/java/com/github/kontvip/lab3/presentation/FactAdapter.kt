package com.github.kontvip.lab3.presentation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.github.kontvip.lab3.R
import com.github.kontvip.lab3.domain.model.Fact
import com.github.kontvip.lab3.presentation.home.Listener
import kotlin.random.Random

class FactAdapter(private val facts: List<Fact>, private val listener: Listener) :
    RecyclerView.Adapter<FactAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val layout: LinearLayout
        val textView: TextView
//        val imageView: ImageView
//        val progressBar: ProgressBar

        init {
            layout = view.findViewById(R.id.layout)
            textView = view.findViewById(R.id.textView)
//            imageView = view.findViewById(R.id.imageView)
//            progressBar = view.findViewById(R.id.progressBar)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.fact_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentFact = facts[position]
        currentFact.applyLimitedText(viewHolder.textView)

//        val randomWidth = Random.nextInt(700, 1200)
//        val randomHeight = Random.nextInt(300, 500)
//
//        Glide.with(viewHolder.imageView.context)
//            .load("https://place.dog/$randomWidth/$randomHeight")
//            .addListener(object : RequestListener<Drawable> {
//                override fun onLoadFailed(
//                    e: GlideException?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    viewHolder.progressBar.visibility = View.GONE
//                    return false
//                }
//
//                override fun onResourceReady(
//                    resource: Drawable?,
//                    model: Any?,
//                    target: Target<Drawable>?,
//                    dataSource: DataSource?,
//                    isFirstResource: Boolean
//                ): Boolean {
//                    viewHolder.progressBar.visibility = View.GONE
//                    return false
//                }
//            }).into(viewHolder.imageView)

        viewHolder.layout.setOnClickListener {
            listener.onClick(currentFact)
        }
    }

    override fun getItemCount() = facts.size

}