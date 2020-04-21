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
        TODO("- Criar uma transação de fragmento, chamando o método beginTransaction da propriedade supportFragmentManager" +
                "- Através do objeto retornado da função acima, usar o método add, passando como paramêtro o valor R.id.mainConstraintLayout e a propriedade memeSplashFragment" +
                "- Chamar o método commit deste objeto" +
                "- Chamar o método callGetMemes da propridade memePresenter")
    }

    override fun onReceivedMemes(memes: ArrayList<Meme>) {
        TODO("- Se a propriedade memeListFragment estiver vazia:" +
                "1. Criar uma transação de fragmento, chamando o método beginTransaction da propriedade supportFragmentManager" +
                "2. Instânciar a propriedade memeListFragment através da função estática newInstance da classe MemeListFragment" +
                "3. Através do objeto retornado da função acima, usar o método replace, passando como paramêtro o valor R.id.mainConstraintLayout e a propriedade memeListFragment" +
                "4. Chamar o método commit deste objeto" +
                "- Senão:" +
                "1. Chamar o método reload da propriedade memeListFragment passando como paramêtro a lista recebida")
    }

    override fun onRefresh() {
        TODO("Chamar o método callGetMemes da propridade memePresenter")
    }
}
