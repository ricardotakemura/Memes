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
        memeSwipeRefreshLayout = view.findViewById(R.id.memeSwipeRefreshLayout)
        memeRecyclerView = view.findViewById<RecyclerView>(R.id.memeRecycleView).apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(this.context)
            adapter = MemeRecycleViewAdapter(memes)
        }
        if (onRefreshListener != null) {
            memeSwipeRefreshLayout?.setOnRefreshListener(onRefreshListener)
        }
        return view
    }

    fun setOnRefreshListener(onRefreshListener: SwipeRefreshLayout.OnRefreshListener) {
        this.onRefreshListener = onRefreshListener
        if (memeSwipeRefreshLayout != null) {
            memeSwipeRefreshLayout?.setOnRefreshListener(onRefreshListener)
        }
    }

    fun reload(memes: ArrayList<Meme>) {
        memeRecyclerView?.adapter = MemeRecycleViewAdapter(memes)
        memeSwipeRefreshLayout?.isRefreshing = false
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
