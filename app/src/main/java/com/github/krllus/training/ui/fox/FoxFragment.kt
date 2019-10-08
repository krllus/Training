package com.github.krllus.training.ui.fox


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import coil.api.load
import com.github.krllus.training.R
import com.github.krllus.training.dagger.inject
import com.github.krllus.training.ui.common.NavigationController
import com.github.krllus.training.viewmodels.FoxViewModel
import com.github.krllus.training.viewmodels.FoxViewModelFactory
import javax.inject.Inject

class FoxFragment : Fragment() {

    companion object {
        const val FOX_ID = "foxId"

        fun newInstance(foxId: String) = FoxFragment().apply {
            arguments = Bundle().apply {
                putString(FOX_ID, foxId)
            }
        }
    }

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    internal lateinit var foxViewModelFactory: FoxViewModelFactory

    private lateinit var foxViewModel: FoxViewModel
    private val retrievedFoxId: String by lazy {
        arguments?.getString(FOX_ID) ?: "1"
    }

    private lateinit var txtFoxLabel: TextView
    private lateinit var imgFox: ImageView
    private lateinit var btnPrevious: Button
    private lateinit var btnRandom: Button
    private lateinit var btnNext: Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fox_fragment, container, false)

        txtFoxLabel = view.findViewById(R.id.fox_label)
        imgFox = view.findViewById(R.id.fox_image_view)
        btnPrevious = view.findViewById(R.id.button_previous)
        btnRandom = view.findViewById(R.id.button_random)
        btnNext = view.findViewById(R.id.button_next)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foxViewModel = ViewModelProviders
            .of(this, foxViewModelFactory)
            .get(FoxViewModel::class.java)
            .apply {
                fox.observe(viewLifecycleOwner) {
                    setFoxId(retrievedFoxId)
                    imgFox.load(it.image) {
                        crossfade(true)
                        placeholder(R.drawable.placeholder_fox)
                    }
                }
            }
    }


}


