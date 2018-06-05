package com.reihanalavi.leagueteams.repo

import java.net.URL

/**
 * Created by rehan on 6/5/2018.
 */
class ApiRepo {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }

}