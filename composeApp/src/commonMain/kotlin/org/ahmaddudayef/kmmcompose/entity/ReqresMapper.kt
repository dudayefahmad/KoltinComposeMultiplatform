package org.ahmaddudayef.kmmcompose.entity

import org.ahmaddudayef.kmmcompose.entity.data.User
import org.ahmaddudayef.kmmcompose.entity.response.ReqresResponse

object ReqresMapper {

    fun mapResponseToUser(reqresResponse: ReqresResponse?): User {
        val firstName = reqresResponse?.data?.firstOrNull()?.firstName
        val lastName = reqresResponse?.data?.firstOrNull()?.lastName

        return User(
            name = "${firstName.orEmpty()} ${lastName.orEmpty()}".trim()
        )
    }
}