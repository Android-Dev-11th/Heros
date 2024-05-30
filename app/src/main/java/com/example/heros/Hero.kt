package com.example.heros
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    val name:String,
    public val description:String,
    public val superpower:String,
    public val ranking:Int,
    val image:String
    ): Parcelable, Comparable<Hero> {
    override fun compareTo(other: Hero): Int {
        //ranking is natural ordering
        return this.ranking - other.ranking
    }
}




