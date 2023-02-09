package com.turtle.multimodulehilt.feature.avengers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.turtle.multimodulehilt.core.common.base.BaseViewModel
import com.turtle.multimodulehilt.core.domain.usecase.GetMarvelUseCase
import com.turtle.multimodulehilt.core.model.Comic
import com.turtle.multimodulehilt.core.model.ComicThumbnail
import com.turtle.multimodulehilt.core.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AvengersDetailViewModel @Inject constructor(
    private val marvelUseCase: GetMarvelUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val _heroData = MutableLiveData<Hero>()
    val heroData: LiveData<Hero> get() = _heroData

    private val _comicData = MutableLiveData<List<Comic>>()
    val comicData: LiveData<List<Comic>> get() = _comicData

    init {
        _heroData.value = savedStateHandle["hero"]
        getComicById()
    }
    fun getComicById() {

        compositeDisposable.add(
            marvelUseCase
                .getComicById(id = heroData.value!!.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onError = { throwable ->
                        showMessage(throwable.message!!)
                    },
                    onSuccess = { result ->
                        _comicData.value = result.data.results
                    }
                )
        )

    }


}