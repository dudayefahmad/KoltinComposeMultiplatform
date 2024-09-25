package org.ahmaddudayef.kmmcompose.repository

import kotlinx.coroutines.flow.Flow
import org.ahmaddudayef.kmmcompose.base.BaseRepository
import org.ahmaddudayef.kmmcompose.base.State
import org.ahmaddudayef.kmmcompose.entity.ReqresMapper
import org.ahmaddudayef.kmmcompose.entity.data.User
import org.ahmaddudayef.kmmcompose.entity.response.ReqresResponse

class ReqresRepository : BaseRepository() {

    fun getUser(): Flow<State<User>> {
        return suspend {
            getHttpResponse("https://reqres.in/api/users?page=2")
        }.reduce<ReqresResponse, User> {
            val user = ReqresMapper.mapResponseToUser(it)
            State.Success(user)
        }
    }

}

