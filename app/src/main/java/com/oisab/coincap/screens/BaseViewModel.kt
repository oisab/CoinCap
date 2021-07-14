package com.oisab.coincap.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<S, A, E>: ViewModel() {

    private val _viewStates: MutableLiveData<S> = MutableLiveData()
    fun viewStates(): LiveData<S> = _viewStates

    private var _viewState: S? = null
    protected var viewState: S
    get() = _viewState
        ?: throw UninitializedPropertyAccessException("viewState was required before being initialized")
    set(value: S) {
        _viewState = value
        _viewStates.postValue(value)
    }

    private val _viewActions: SingleLiveAction<A> = SingleLiveAction()
    fun viewActions(): SingleLiveAction<A> = _viewActions

    private var _viewAction: A? = null
    private var viewAction: A
        get() = _viewAction
            ?: throw UninitializedPropertyAccessException("viewAction was required before being initialized")
        set(value: A) {
            _viewAction = value
            _viewActions.postValue(value)
        }

    abstract fun obtainEvent(viewEvent: E)
}