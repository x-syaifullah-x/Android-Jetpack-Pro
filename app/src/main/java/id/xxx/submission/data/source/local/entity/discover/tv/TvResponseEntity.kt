package id.xxx.submission.data.source.local.entity.discover.tv

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    indices = [
        Index(value = ["page"], unique = true)
    ]
)
data class TvResponseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_TV_RESPONSE)
    val id_movie_response: Int? = null,

    val page: Int = 0,

    val total_results: Int = 0,

    val total_pages: Int = 0,

    ) : Parcelable {
    companion object {
        const val ID_TV_RESPONSE = "id_tv_response"
    }
}