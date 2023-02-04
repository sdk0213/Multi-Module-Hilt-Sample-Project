package com.turtle.multimodulehilt.feature.avengers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.turtle.multimodulehilt.core.common.base.BaseViewModel
import com.turtle.multimodulehilt.core.domain.usecase.GetMarvelHeroesUseCase
import com.turtle.multimodulehilt.core.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AvengersViewModel @Inject constructor(
    private val getHeroes: GetMarvelHeroesUseCase,
) : BaseViewModel() {

    private val _heroData = MutableLiveData<List<Hero>>()
    val heroData: LiveData<List<Hero>> get() = _heroData

    init {
        getHeroesFromNetwork()
    }

    fun getHeroesFromNetwork() {

        compositeDisposable.add(
            getHeroes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onError = { throwable ->
                        showMessage(throwable.message!!)
                    },
                    onSuccess = { result ->
                        _heroData.value = result.data.results
                    }
                )
        )

    }


}