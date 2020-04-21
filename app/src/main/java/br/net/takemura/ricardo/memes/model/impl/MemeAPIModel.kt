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
        TODO("Obter os dados do serviço REST/JSON (urlMeme) como String e fazer parse do resultado para uma lista de objetos da classe Meme")
    }
}