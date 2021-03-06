package id.xxx.submission.data.model.the_movie_db

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LastEpisodeToAir(
    val air_date: String = "",
    val episode_number: Int = 0,
    val id: Int,
    val name: String = "",
    val overview: String = "",
    val production_code: String = "",
    val season_number: Int = 0,
    val show_id: Int = 0,
    val still_path: String = "",
    val vote_average: Float = 0.0f,
    val vote_count: Int = 0
) : Parcelable