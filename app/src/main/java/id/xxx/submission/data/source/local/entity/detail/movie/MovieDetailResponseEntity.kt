package id.xxx.submission.data.source.local.entity.detail.movie

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class MovieDetailResponseEntity(
    @PrimaryKey
    @ColumnInfo(name = PK)
    val pk: Int,
    var isFavorite: Boolean = false,
    val adult: Boolean = false,
    val backdrop_path: String? = "",
    val budget: Int = 0,
    val homepage: String? = "",
    val imDbId: String? = "",
    val original_language: String? = "",
    val original_title: String? = "",
    val overview: String? = "",
    val popularity: Double = 0.0,
    val poster_path: String? = "",
    val release_date: String? = "",
    val revenue: Int = 0,
    val runtime: Int = 0,
    val status: String? = "",
    val tagLine: String? = "",
    val title: String? = "",
    val video: Boolean = false,
    val vote_average: Float = 0.0f,
    val vote_count: Int = 0
) : Parcelable {
    companion object {
        const val PK = "pk_movie_detail_response"
    }
}