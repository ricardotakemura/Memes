package br.net.takemura.ricardo.memes.model

import br.net.takemura.ricardo.memes.model.dto.Meme

interface MemeModel {
    fun getMemes(): ArrayList<Meme>
}