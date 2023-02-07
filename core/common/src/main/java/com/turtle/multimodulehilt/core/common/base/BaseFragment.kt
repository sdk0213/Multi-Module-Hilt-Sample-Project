package com.turtle.multimodulehilt.core.common.base

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.disposables.CompositeDisposable


abstract class BaseFragment<B : ViewDataBinding>
constructor(@LayoutRes private val layoutId: Int) : Fragment() {

    var compositeDisposable = CompositeDisposable()

    protected val handler by lazy {
        Handler(Looper.getMainLooper())
    }

    lateinit var mContext: Context

    private var _binding: B? = null

    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, layoutId, null, false)
        binding.lifecycleOwner = viewLifecycleOwner
        mContext = inflater.context
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding?.unbind()
        handler.removeCallbacksAndMessages(null)
    }

    abstract fun init()

    protected fun showToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}