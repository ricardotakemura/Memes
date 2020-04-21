package br.net.takemura.ricardo.memes.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.net.takemura.ricardo.memes.R
import br.net.takemura.ricardo.memes.model.dto.Meme
import br.net.takemura.ricardo.memes.view.util.ImageViewUtil
import java.net.URL

class MemeRecycleViewAdapter(private val memes: ArrayList<Meme>?) :
    RecyclerView.Adapter<MemeRecycleViewAdapter.MemeViewHolder>() {
    class MemeViewHolder(val view: View, private val context: Context) :
        RecyclerView.ViewHolder(view) {
        private val imageViewUtil = ImageViewUtil()

        var meme: Meme? = null
            set(value) {
                field = value
                val memeImageView = this.itemView.findViewById<ImageView>(R.id.memeImageView)
                val memeTextView = this.itemView.findViewById<TextView>(R.id.memeTextView)
                memeTextView.text = value?.name
                val displayMetrics = context.applicationContext.resources.displayMetrics
                imageViewUtil.loadAsyncImageURL(memeImageView, URL(meme?.url))
                val height = ((value?.height ?: 0) * displayMetrics.widthPixels) / (value?.width
                    ?: displayMetrics.widthPixels)
                memeImageView.layoutParams.height = height
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_meme_item, parent, false)
        return MemeViewHolder(view, parent.context)
    }

    override fun getItemCount(): Int {
        return memes?.size ?: 0
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        holder.meme = memes?.get(position)
    }
}