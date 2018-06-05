package com.reihanalavi.leagueteams.views

import com.reihanalavi.leagueteams.models.TeamItems

/**
 * Created by rehan on 6/5/2018.
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeague(data: List<TeamItems>)
}