package br.net.takemura.ricardo.memes.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.net.takemura.ricardo.memes.R

/**
 * A simple [Fragment] subclass.
 * Use the [MemeSplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MemeSplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meme_splash, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment SplashFragment.
         */
        @JvmStatic
        fun newInstance() =
            MemeSplashFragment()
    }
}
