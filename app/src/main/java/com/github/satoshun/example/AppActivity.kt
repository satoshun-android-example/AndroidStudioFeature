package com.github.satoshun.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.databinding.AppActBinding
import com.github.satoshun.example.databinding.AppFragBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.app_act)
  }
}

class AppFragment : Fragment(R.layout.app_frag) {
  private val binding: AppFragBinding by dataBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.desugarTime.setOnClickListener {
      findNavController().navigate(AppFragmentDirections.navAppToDesguarTime())
    }
  }
}
