package af.airpay.jetpackcomposemigration.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import af.airpay.jetpackcomposemigration.R
import af.airpay.jetpackcomposemigration.screen.FirstScreen
import af.airpay.jetpackcomposemigration.screen.FirstViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    lateinit var composeView: ComposeView
    private val viewModel: FirstViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        return ComposeView(requireContext()).also {
            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        composeView.setContent {

            val state by viewModel.state.collectAsState()

            FirstScreen(
                state = state,
                onNextClick = {
                    findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
                }
            )
        }


    }


}