package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLevelBinding

/**
 * A simple [Fragment] subclass.
 */
class LevelFragment : Fragment() {
    lateinit var binding: FragmentLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_level, container, false)

        binding.btnLevelStart1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_levelFragment_to_levelRulesFragment)
        }

        return binding.root
    }


}
