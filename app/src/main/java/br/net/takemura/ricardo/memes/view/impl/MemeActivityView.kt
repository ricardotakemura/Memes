package br.net.takemura.ricardo.memes.view.impl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import br.net.takemura.ricardo.memes.R
import br.net.takemura.ricardo.memes.model.dto.Meme
import br.net.takemura.ricardo.memes.model.impl.MemeAPIModel
import br.net.takemura.ricardo.memes.presenter.impl.MemeAsyncTaskPresenter
import br.net.takemura.ricardo.memes.view.MemeView
import br.net.takemura.ricardo.memes.view.fragment.MemeListFragment
import br.net.takemura.ricardo.memes.view.fragment.MemeSplashFragment

class MemeActivityView : AppCompatActivity(), MemeView, SwipeRefreshLayout.OnRefreshListener {
    private val memePresenter = MemeAsyncTaskPresenter(this, MemeAPIModel())
    private var memeListFragment: MemeListFragment? = null
    private val memeSplashFragment = MemeSplashFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meme)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mainConstraintLayout, memeSplashFragment)
        transaction.commit()
        memePresenter.callGetMemes()
    }

    override fun onReceivedMemes(memes: ArrayList<Meme>) {
        if (memeListFragment == null) {
            val transaction = supportFragmentManager.beginTransaction()
            memeListFragment = MemeListFragment.newInstance(memes)
            transaction.replace(R.id.mainConstraintLayout, memeListFragment!!)
            memeListFragment?.setOnRefreshListener(this)
            transaction.commit()
        } else {
            memeListFragment?.reload(memes)
        }
    }

    override fun onRefresh() {
        memePresenter.callGetMemes()
    }
}
