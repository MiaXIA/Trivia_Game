package com.example.mcxia.trivia.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mc.xia on 2017/9/18.
 */
@Parcelize
data class GameData(val questions: List<Question>, val triviaCategory: String): Parcelable