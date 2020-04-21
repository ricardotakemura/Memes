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
                TODO("Ao setar o valor da propriedade meme, colocar os valores nas Views correspondentes (objetos visuais da tela)")
                TODO("Para a imagem, utilize o método estático ImageViewUtil.loadAsyncImageURL passando como paramêtros o objeto visual da class ImageView e a propriedade url do objeto da classe Meme")
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemeViewHolder {
        TODO("Criar uma View do layout R.layout.view_meme_item")
        TODO("Criar uma instância da classe MemeViewHolder passando a View do layout R.layout.view_meme_item e o Context")
    }

    override fun getItemCount(): Int {
        TODO("Retornar o tamanho da lista de Meme (propriedade)")
    }

    override fun onBindViewHolder(holder: MemeViewHolder, position: Int) {
        TODO("Setar a propriedade meme do objeto holder com um valor da lista de Meme (indicado pela variável position)")
    }
}