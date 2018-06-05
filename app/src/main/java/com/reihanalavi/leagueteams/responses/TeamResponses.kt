package com.reihanalavi.leagueteams.responses

import com.google.gson.annotations.SerializedName
import com.reihanalavi.leagueteams.models.TeamItems

/**
 * Created by rehan on 6/5/2018.
 */
data class TeamResponses (
        @SerializedName("teams") var teamItems: List<TeamItems>
)