package com.example.collegecounselor


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.collegecounselor.databinding.FragmentLevelRulesBinding

/**
 * A simple [Fragment] subclass.
 */
class LevelRulesFragment : Fragment() {
    lateinit var binding: FragmentLevelRulesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_level_rules, container, false)

        binding.btnOk.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_levelRulesFragment_to_questionFragment)
        }

        return binding.root
    }


}
