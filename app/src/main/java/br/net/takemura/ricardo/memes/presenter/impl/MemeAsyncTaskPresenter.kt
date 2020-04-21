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
            return memeModel.getMemes()
        }

        override fun onPostExecute(result: ArrayList<Meme>?) {
            super.onPostExecute(result)
            memeView.onReceivedMemes(result!!)
        }
    }

    override fun callGetMemes() {
        asyncTask?.cancel(true)
        asyncTask = MemeAsyncTask(memeView, memeModel)
        asyncTask?.execute()
    }
}