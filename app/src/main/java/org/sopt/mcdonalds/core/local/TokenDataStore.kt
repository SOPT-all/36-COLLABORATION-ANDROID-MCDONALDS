package org.sopt.mcdonalds.core.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import javax.inject.Inject
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import org.sopt.mcdonalds.BuildConfig

class TokenDataStore @Inject constructor(
    private val preferenceDataStore: DataStore<Preferences>
) {
    suspend fun getAccessToken(): String? = preferenceDataStore.data.map { preferences ->
        preferences[preferencesTokenKey] ?: TEMPORARY_TOKEN
    }.firstOrNull()

    suspend fun setAccessToken(token: String) {
        preferenceDataStore.edit { preferences ->
            preferences[preferencesTokenKey] = token
        }
    }

    suspend fun clearInfo() {
        preferenceDataStore.edit { preferences ->
            preferences.remove(preferencesTokenKey)
        }
    }

    companion object {
        private const val TOKEN_KEY = "token_key"
        private val preferencesTokenKey = stringPreferencesKey(TOKEN_KEY)

        private const val TEMPORARY_TOKEN = BuildConfig.USER_TOKEN
    }
}
