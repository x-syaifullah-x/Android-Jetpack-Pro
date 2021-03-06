package id.xxx.submission.data.source.local.entity.detail.tv

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class TvDetailResponseEntity(
    @PrimaryKey
    @ColumnInfo(name = PK)
    val pk: Int,
    var isFavorite: Boolean = false,
    val backdrop_path: String? = "",
    val first_air_date: String? = "",
    val homepage: String? = "",
    val in_production: Boolean = false,
    val last_air_date: String? = "",
    val name: String? = "",
    val number_of_episodes: Int = 0,
    val number_of_seasons: Int = 0,
    val original_language: String? = "",
    val original_name: String? = "",
    val overview: String? = "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val status: String? = "",
    val type: String? = "",
    val vote_average: Float = 0.0f,
    val vote_count: Int = 0
) : Parcelable {
    companion object {
        const val PK = "pk_id_tv_detail_response"
    }
}