package com.github.satoshun.example

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.navigation.fragment.findNavController
import com.github.satoshun.example.databinding.AppActBinding
import com.github.satoshun.example.databinding.AppFragBinding

class AppActivity : AppCompatActivity() {
  private lateinit var binding: AppActBinding

  private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {}
  private val normalContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.app_act)

    ViewTreeLifecycleOwner.set(window.decorView, this)
    binding.root.findViewTreeLifecycleOwner()!!

    getContent.launch("")
    normalContracts.launch(Intent())
  }
}

class AppFragment : Fragment(R.layout.app_frag) {
  private val binding: AppFragBinding by dataBinding()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.desugarTime.setOnClickListener {
      findNavController().navigate(AppFragmentDirections.navAppToDesguarTime())
    }

    println("Hit: ${view.findViewTreeLifecycleOwner()}")
  }
}
