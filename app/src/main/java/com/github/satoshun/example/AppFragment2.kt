package com.github.satoshun.example

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.databinding.AppFrag2Binding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AppFragment2 : Fragment(R.layout.app_frag2) {
  private val binding: AppFrag2Binding by viewBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.desugarTime.setOnClickListener {
      findNavController().navigate(AppFragmentDirections.navAppToDesguarTime())
    }

    binding.root.findViewTreeLifecycleOwner()!!.lifecycleScope.launch {
      delay(1000)
      println(1000)
    }
  }
}
