package com.reihanalavi.leagueteams.views

import android.util.Log
import com.google.gson.Gson
import com.reihanalavi.leagueteams.repo.ApiCall
import com.reihanalavi.leagueteams.repo.ApiRepo
import com.reihanalavi.leagueteams.responses.TeamResponses
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by rehan on 6/5/2018.
 */
class MainPresenter (
        private val view: MainView,
        private val apiRepo: ApiRepo,
        private val gson: Gson) {

    fun getLeague(league: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepo
                    .doRequest(ApiCall.getLeague(league)),
                    TeamResponses::class.java
            )
            uiThread {
                view.hideLoading()
                view.showLeague(data.teamItems)
                Log.i("Team Size : ", data.teamItems.toString())
            }
        }

    }

}