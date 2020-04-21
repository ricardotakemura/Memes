package br.net.takemura.ricardo.memes.model.impl

import br.net.takemura.ricardo.memes.model.MemeModel
import br.net.takemura.ricardo.memes.model.dto.Meme
import org.json.JSONObject
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import kotlin.collections.ArrayList

class MemeAPIModel : MemeModel {
    private val urlMeme = URL("https://api.imgflip.com/get_memes")

    override fun getMemes(): ArrayList<Meme> {
        val memes = ArrayList<Meme>()
        val httpsURLConnection = urlMeme.openConnection() as HttpsURLConnection
        httpsURLConnection.requestMethod = "GET"
        httpsURLConnection.connect()
        if (httpsURLConnection.responseCode == 200) {
            val json = httpsURLConnection.inputStream.bufferedReader().readText()
            val rootNode = JSONObject(json)
            val success = rootNode.getBoolean("success")
            if (success) {
                val memesNode = rootNode.getJSONObject("data").getJSONArray("memes")
                for (i in 0 until memesNode.length() - 1) {
                    val memeNode = memesNode.getJSONObject(i)
                    memes.add(
                        Meme(
                            memeNode.getString("id"),
                            memeNode.getString("name"),
                            memeNode.getString("url"),
                            memeNode.getInt("width"),
                            memeNode.getInt("height"),
                            memeNode.getInt("box_count")
                        )
                    )
                }
            }
        }
        return memes
    }
}