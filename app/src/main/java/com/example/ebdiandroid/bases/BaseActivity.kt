package com.example.ebdiandroid.bases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseActivity<V : BaseViewModel> : AppCompatActivity() {

    abstract val binding: ViewBinding

    val viewModel: V by lazy { getViewModel(clazz = viewModelClass()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }


    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<V> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<V>).kotlin
    }
}