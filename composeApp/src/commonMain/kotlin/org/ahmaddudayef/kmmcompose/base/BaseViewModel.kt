package org.ahmaddudayef.kmmcompose.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<MODEL, INTENT>(private val defaultModel: MODEL) : ViewModel() {

    private val mutableStateData: MutableStateFlow<MODEL> = MutableStateFlow(defaultModel)
    val stateModelData: StateFlow<MODEL> get() = mutableStateData

    abstract fun handleIntent(appIntent: INTENT)

    fun updateModel(block: (MODEL) -> MODEL) {
        mutableStateData.update(block)
    }

    fun restartState() {
        mutableStateData.value = defaultModel
    }

}