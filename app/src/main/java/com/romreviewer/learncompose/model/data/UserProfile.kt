package com.romreviewer.learncompose.model.data

import com.romreviewer.learncompose.R

data class UserProfile(val name: String, val status: Boolean, val drawable: Int)

val userProfileList = mutableListOf<UserProfile>(
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
    UserProfile("Lolu Lol", true, R.drawable.cool_profile_picture),
    UserProfile("RomReviewer", false, R.drawable.cool_profile_picture),
)