package com.reihanalavi.leagueteams.models

import com.google.gson.annotations.SerializedName

/**
 * Created by rehan on 6/5/2018.
 */
data class TeamItems (

        @SerializedName("idTeam") var teamId: String? = null,
        @SerializedName("strTeam") var teamName: String? = null,
        @SerializedName("strTeamBadge") var teamBadge: String? = null

)