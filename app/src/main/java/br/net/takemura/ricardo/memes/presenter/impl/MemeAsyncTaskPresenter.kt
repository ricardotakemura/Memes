package br.net.takemura.ricardo.memes.presenter.impl

import android.os.AsyncTask
import br.net.takemura.ricardo.memes.model.MemeModel
import br.net.takemura.ricardo.memes.model.dto.Meme
import br.net.takemura.ricardo.memes.presenter.MemePresenter
import br.net.takemura.ricardo.memes.view.MemeView

class MemeAsyncTaskPresenter(private val memeView: MemeView, private val memeModel: MemeModel): MemePresenter {
    private var asyncTask: MemeAsyncTask? = null

    private class MemeAsyncTask(private val memeView: MemeView, private val memeModel: MemeModel): AsyncTask<Void, Void, ArrayList<Meme>>() {
        override fun doInBackground(vararg params: Void?): ArrayList<Meme> {
            TODO("Chamar o método getMemes do objeto memeModel e retornar a lista devolvida")
        }

        override fun onPostExecute(result: ArrayList<Meme>?) {
            TODO("Chamar o método onReceivedMemes do objeto memeView e passar a lista recebida como parâmetro")
        }
    }

    override fun callGetMemes() {
        TODO("- Chamar o método cancel do objeto asyncTask" +
                "- Instanciar o objeto asyncTask" +
                "- Chamar o método execute do objeto asyncTask")
    }
}