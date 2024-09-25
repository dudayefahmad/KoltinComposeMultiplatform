package org.ahmaddudayef.kmmcompose

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.ahmaddudayef.kmmcompose.base.BaseViewModel
import org.ahmaddudayef.kmmcompose.repository.ReqresRepository
import org.ahmaddudayef.kmmcompose.base.State
import org.ahmaddudayef.kmmcompose.entity.data.User

sealed class AppIntent {
    data object GetApi : AppIntent()
    data object UpdateCounter : AppIntent()
}

data class AppModel(
    val counter: Int = 0, val reqresResponse: State<User> = State.Idle
)

class AppViewModel(
    private val reqresRepository: ReqresRepository = ReqresRepository()
) : BaseViewModel<AppModel, AppIntent>(AppModel()) {



    override fun handleIntent(appIntent: AppIntent) {
        when (appIntent) {
            is AppIntent.GetApi -> getApi()
            is AppIntent.UpdateCounter -> updateCounter()
        }
    }

    private fun getApi() = viewModelScope.launch {
        reqresRepository.getUser().stateIn(this).collectLatest { state ->
                updateModel { model ->
                    model.copy(
                        reqresResponse = state
                    )
                }
            }
    }

    private fun updateCounter() {
        updateModel { model ->
            model.copy(
                counter = model.counter + 1
            )
        }
    }


}