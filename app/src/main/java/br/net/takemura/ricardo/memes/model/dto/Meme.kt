package br.net.takemura.ricardo.memes.model.dto

import java.io.Serializable

data class Meme(val id: String, val name: String, val url: String, val width: Int, val height: Int, val boxCount: Int): Serializable