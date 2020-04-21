package br.net.takemura.ricardo.memes.view

import br.net.takemura.ricardo.memes.model.dto.Meme

interface MemeView {
    fun onReceivedMemes(memes: ArrayList<Meme>)
}