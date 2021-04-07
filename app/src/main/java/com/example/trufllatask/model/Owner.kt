package com.example.trufllatask.model

import androidx.room.Entity
import com.example.trufllatask.constants.Constants.Companion.owner_table
import java.io.Serializable

@Entity(tableName = owner_table)
data class Owner(
    var avatar_url: String,
    var events_url: String,
    var followers_url: String,
    var following_url: String,
    var gists_url: String,
    var gravatar_id: String,
    var html_url: String,
    var id: Int,
    var login: String,
    var node_id: String,
    var organizations_url: String,
    var received_events_url: String,
    var repos_url: String,
    var site_admin: Boolean,
    var starred_url: String,
    var subscriptions_url: String,
    var type: String,
    var url: String
) : Serializable