package com.example.buildblitz.item

import android.os.Parcel
import android.os.Parcelable

data class Builds(
    val id:Int,
    val usuario: String,
    val personaje:String,
    val build:String,
    val objeto1:String,
    val fotoobjeto1:String,
    val objeto2:String,
    val fotoobjeto2:String,
    val objeto3:String,
    val fotoobjeto3:String,
    val objeto4:String,
    val fotoobjeto4:String,
    val objeto5:String,
    val fotoobjeto5:String,
    val objeto6:String,
    val fotoobjeto6:String,
    var esFavorita:Boolean
    ):Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
        parcel.readString() ?: "",
            parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )


override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(usuario)
    parcel.writeString(personaje)
    parcel.writeString(build)
    parcel.writeByte(if (esFavorita) 1 else 0)
}

override fun describeContents(): Int {
    return 0
}

companion object CREATOR : Parcelable.Creator<Builds> {
    override fun createFromParcel(parcel: Parcel): Builds {
        return Builds(parcel)
    }

    override fun newArray(size: Int): Array<Builds?> {
        return arrayOfNulls(size)
    }
}
    }

