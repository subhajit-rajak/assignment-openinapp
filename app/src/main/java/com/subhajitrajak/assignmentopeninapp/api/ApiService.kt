package com.subhajitrajak.assignmentopeninapp.api

import com.subhajitrajak.assignmentopeninapp.models.LinksData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/v1/dashboardNew")
    suspend fun getLinksData(): Response<LinksData>
}