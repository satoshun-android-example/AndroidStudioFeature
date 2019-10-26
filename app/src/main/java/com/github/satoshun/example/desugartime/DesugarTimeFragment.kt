package com.github.satoshun.example.desugartime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.satoshun.example.databinding.DesugarTimeFragBinding
import java.util.Date

class DesugarTimeFragment : Fragment() {
  private lateinit var binding: DesugarTimeFragBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = DesugarTimeFragBinding.inflate(
      inflater,
      container,
      false
    )
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val date = Date()
    date.toInstant()
  }
}
