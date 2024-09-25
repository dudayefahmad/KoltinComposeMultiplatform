package org.ahmaddudayef.kmmcompose.entity.response


import    kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReqresResponse(
    @SerialName("data")
    val `data`: List<Data?>? = null,
    @SerialName("page")
    val page: Int? = null,
    @SerialName("per_page")
    val perPage: Int? = null,
    @SerialName("support")
    val support: Support? = null,
    @SerialName("total")
    val total: Int? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null
) {
    @Serializable
    data class Data(
        @SerialName("avatar")
        val avatar: String?,
        @SerialName("email")
        val email: String?,
        @SerialName("first_name")
        val firstName: String?,
        @SerialName("id")
        val id: Int?,
        @SerialName("last_name")
        val lastName: String?
    )

    @Serializable
    data class Support(
        @SerialName("text")
        val text: String?,
        @SerialName("url")
        val url: String?
    )
}