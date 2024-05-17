package af.airpay.jetpackcomposemigration.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import af.airpay.jetpackcomposemigration.R
import af.airpay.jetpackcomposemigration.databinding.FragmentSecondBinding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.navigation.fragment.findNavController


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setContent {
            Button(onClick = {
                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }) {
                Text(text = "Previous")
            }
        }

    }
}