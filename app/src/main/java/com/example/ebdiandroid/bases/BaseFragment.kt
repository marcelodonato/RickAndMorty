package com.example.ebdiandroid.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.ViewBinding
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.model.CharacterItemEntity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseFragment<V : BaseViewModel> : Fragment() {

    abstract val binding: ViewBinding

    val viewModel: V by lazy { getViewModel(clazz = viewModelClass()) }

    private val toolbarTitle = MutableLiveData<String>()

    var listOfCharacter: List<CharacterItemEntity> = listOf()
        set(value) {
            (activity as BaseContainerActivity<*>).listOfCharacter = value
             field = value
        }


    abstract fun initView()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    fun onTitleChanged(): LiveData<String> = toolbarTitle

    fun setTitle(title: String) = toolbarTitle.postValue(title)

    fun navigateTo(
        fragment: Fragment,
        backStack: String?,
        replace: Boolean = false,
        enterAnimation: Int = R.anim.slide_in_right,
        exitAnimation: Int = R.anim.slide_out_right,
        clearStack: Boolean = true,
        clearTop: Boolean = false
    ) {
        (activity as? BaseContainerActivity<*>)?.navigateTo(
            fragment, backStack, replace, enterAnimation, exitAnimation, clearStack, clearTop
        )

    }

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<V> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<V>).kotlin
    }
}