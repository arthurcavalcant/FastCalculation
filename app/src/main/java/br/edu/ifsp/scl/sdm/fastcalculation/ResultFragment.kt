package br.edu.ifsp.scl.sdm.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.ifsp.scl.sdm.fastcalculation.Extras.EXTRA_POINTS
import br.edu.ifsp.scl.sdm.fastcalculation.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var fragmentResultBinding: FragmentResultBinding
    private var points: Float? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            points = it.getFloat(EXTRA_POINTS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)
        "%.1f".format(points).also {
            fragmentResultBinding.valueTv.text = it
        }
        fragmentResultBinding.restartGameBt.setOnClickListener {
            (context as OnPlayGame).onPlayGame()
        }
        return fragmentResultBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(points: Float) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putFloat(EXTRA_POINTS, points)
                }
            }
    }
}