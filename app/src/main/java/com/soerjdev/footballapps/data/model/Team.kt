package com.soerjdev.footballapps.data.model


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("teams")
    val teams: List<Team>?
) {
    data class Team(
        @SerializedName("idAPIfootball")
        val idAPIfootball: String?,
        @SerializedName("idLeague")
        val idLeague: String?,
        @SerializedName("idLeague2")
        val idLeague2: Any?,
        @SerializedName("idLeague3")
        val idLeague3: Any?,
        @SerializedName("idLeague4")
        val idLeague4: Any?,
        @SerializedName("idLeague5")
        val idLeague5: Any?,
        @SerializedName("idLeague6")
        val idLeague6: Any?,
        @SerializedName("idLeague7")
        val idLeague7: Any?,
        @SerializedName("idSoccerXML")
        val idSoccerXML: Any?,
        @SerializedName("idTeam")
        val idTeam: String?,
        @SerializedName("intFormedYear")
        val intFormedYear: String?,
        @SerializedName("intLoved")
        val intLoved: Any?,
        @SerializedName("intStadiumCapacity")
        val intStadiumCapacity: String?,
        @SerializedName("strAlternate")
        val strAlternate: String?,
        @SerializedName("strCountry")
        val strCountry: String?,
        @SerializedName("strDescriptionCN")
        val strDescriptionCN: Any?,
        @SerializedName("strDescriptionDE")
        val strDescriptionDE: Any?,
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: String?,
        @SerializedName("strDescriptionES")
        val strDescriptionES: Any?,
        @SerializedName("strDescriptionFR")
        val strDescriptionFR: Any?,
        @SerializedName("strDescriptionHU")
        val strDescriptionHU: Any?,
        @SerializedName("strDescriptionIL")
        val strDescriptionIL: Any?,
        @SerializedName("strDescriptionIT")
        val strDescriptionIT: Any?,
        @SerializedName("strDescriptionJP")
        val strDescriptionJP: Any?,
        @SerializedName("strDescriptionNL")
        val strDescriptionNL: Any?,
        @SerializedName("strDescriptionNO")
        val strDescriptionNO: Any?,
        @SerializedName("strDescriptionPL")
        val strDescriptionPL: Any?,
        @SerializedName("strDescriptionPT")
        val strDescriptionPT: Any?,
        @SerializedName("strDescriptionRU")
        val strDescriptionRU: Any?,
        @SerializedName("strDescriptionSE")
        val strDescriptionSE: Any?,
        @SerializedName("strDivision")
        val strDivision: Any?,
        @SerializedName("strFacebook")
        val strFacebook: String?,
        @SerializedName("strGender")
        val strGender: String?,
        @SerializedName("strInstagram")
        val strInstagram: String?,
        @SerializedName("strKeywords")
        val strKeywords: String?,
        @SerializedName("strLeague")
        val strLeague: String?,
        @SerializedName("strLeague2")
        val strLeague2: Any?,
        @SerializedName("strLeague3")
        val strLeague3: Any?,
        @SerializedName("strLeague4")
        val strLeague4: Any?,
        @SerializedName("strLeague5")
        val strLeague5: Any?,
        @SerializedName("strLeague6")
        val strLeague6: Any?,
        @SerializedName("strLeague7")
        val strLeague7: Any?,
        @SerializedName("strLocked")
        val strLocked: String?,
        @SerializedName("strManager")
        val strManager: String?,
        @SerializedName("strRSS")
        val strRSS: String?,
        @SerializedName("strSport")
        val strSport: String?,
        @SerializedName("strStadium")
        val strStadium: String?,
        @SerializedName("strStadiumDescription")
        val strStadiumDescription: String?,
        @SerializedName("strStadiumLocation")
        val strStadiumLocation: String?,
        @SerializedName("strStadiumThumb")
        val strStadiumThumb: Any?,
        @SerializedName("strTeam")
        val strTeam: String?,
        @SerializedName("strTeamBadge")
        val strTeamBadge: String?,
        @SerializedName("strTeamBanner")
        val strTeamBanner: Any?,
        @SerializedName("strTeamFanart1")
        val strTeamFanart1: Any?,
        @SerializedName("strTeamFanart2")
        val strTeamFanart2: Any?,
        @SerializedName("strTeamFanart3")
        val strTeamFanart3: Any?,
        @SerializedName("strTeamFanart4")
        val strTeamFanart4: Any?,
        @SerializedName("strTeamJersey")
        val strTeamJersey: Any?,
        @SerializedName("strTeamLogo")
        val strTeamLogo: Any?,
        @SerializedName("strTeamShort")
        val strTeamShort: Any?,
        @SerializedName("strTwitter")
        val strTwitter: String?,
        @SerializedName("strWebsite")
        val strWebsite: String?,
        @SerializedName("strYoutube")
        val strYoutube: String?
    )
}