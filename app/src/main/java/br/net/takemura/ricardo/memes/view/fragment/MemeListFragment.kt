package br.net.takemura.ricardo.memes.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import br.net.takemura.ricardo.memes.R
import br.net.takemura.ricardo.memes.model.dto.Meme
import br.net.takemura.ricardo.memes.view.adapter.MemeRecycleViewAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [MemeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemeListFragment : Fragment() {

    private var memes: ArrayList<Meme>? = null
    private val argParamName = "memes"
    private var memeSwipeRefreshLayout: SwipeRefreshLayout? = null
    private var memeRecyclerView: RecyclerView? = null
    private var onRefreshListener: SwipeRefreshLayout.OnRefreshListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            memes = it.getSerializable(argParamName) as ArrayList<Meme>
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meme_list, container, false)
        val memes = arguments?.get(argParamName) as ArrayList<Meme>
        TODO("- Obter a propriedade visual RecyclerView e setar o adapter com uma instância da classe MemeRecycleViewAdapter" +
                "- Obter a propriedade visual RecyclerView e setar o layoutManager com uma instância da classe LinearLayout" +
                "- Obter a propriedade visual RecyclerView e passar o valor false para o método setHasFixedSize" +
                "- Obter a propriedade visual SwipeRefreshLayout e setar o onRefreshListener com a propriedade onRefreshListener")
    }

    fun setOnRefreshListener(onRefreshListener: SwipeRefreshLayout.OnRefreshListener) {
        TODO("- Setar a propriedade onRefreshListener com o valor passado por paramêtro" +
                "- Obter a propriedade visual SwipeRefreshLayout e setar o onRefreshListener com o valor passado por paramêtro")
    }

    fun reload(memes: ArrayList<Meme>) {
        TODO("- Obter a propriedade visual RecyclerView e setar o adapter com uma instância da classe MemeRecycleViewAdapter" +
                "- Obter a propriedade visual SwipeRefreshLayout e setar o isRefreshing com o valor false")
    }

    companion object {
        @JvmStatic
        fun newInstance(memes: ArrayList<Meme>) =
            MemeListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(argParamName, memes)
                }
            }
    }
}
