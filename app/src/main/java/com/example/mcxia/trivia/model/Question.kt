package com.example.mcxia.trivia.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mc.xia on 2017/9/18.
 */

@Parcelize
data class Question(val wrongAnswers: List<Answer>, val correctAnswer:Answer): Parcelable