package com.github.satoshun.example

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewDataBinding> Fragment.dataBinding(): ReadOnlyProperty<Fragment, T> =
  object : ReadOnlyProperty<Fragment, T> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
      val view = thisRef.view!!
      var binding = view.getTag(R.id.fragment_binding) as? T
      if (binding == null) {
        binding = DataBindingUtil.bind(view)!!
        view.setTag(R.id.fragment_binding, binding)
      }
      return binding
    }
  }

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> =
  object : ReadOnlyProperty<Fragment, T> {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
      val view = thisRef.view!!
      var binding = view.getTag(R.id.fragment_binding) as? T
      if (binding == null) {
        val method = T::class.java.getMethod("bind", View::class.java)
        binding = method.invoke(null, view) as T
        view.setTag(R.id.fragment_binding, binding)
      }
      return binding
    }
  }
