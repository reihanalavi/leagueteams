package com.reihanalavi.leagueteams.repo

import com.reihanalavi.leagueteams.BuildConfig

/**
 * Created by rehan on 6/5/2018.
 */
object ApiCall {

    fun getLeague(league: String?): String {
        return BuildConfig.LEAGUE_LIST + league
    }

}