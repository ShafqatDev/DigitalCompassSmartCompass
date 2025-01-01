package com.apt.status.smart.compass.digital.presentation.language

import androidx.lifecycle.ViewModel
import com.apt.status.smart.compass.digital.domain.model.LocalizeModel
import com.apt.status.smart.compass.digital.domain.repository.LanguageRepository
import com.apt.status.smart.compass.digital.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class LanguageState(
    val languagesList: List<LocalizeModel> = emptyList(),
    val selectedLangCode: String = "en",
    val sessionCount: Int = 0
)

class LanguageViewModel(
    private val prefs: PreferencesRepository,
    private val languageRepository: LanguageRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LanguageState())
    val state = _state.asStateFlow()

    init {
        initializeState()
    }

    private fun initializeState() {
        val languages = languageRepository.getAllLanguages()
        val selectedLangCode = prefs.localeLanguageCode
        val sessionCount = prefs.sessionCount

        _state.update {
            it.copy(
                languagesList = languages,
                selectedLangCode = selectedLangCode,
                sessionCount = sessionCount
            )
        }
    }

    fun changeLang(lang: LocalizeModel) {
        _state.update {
            it.copy(selectedLangCode = lang.shortCode)
        }
        prefs.localeLanguageCode = lang.shortCode
    }

    fun incrementSessionCount() {
        val updatedCount = _state.value.sessionCount + 1
        _state.update {
            it.copy(sessionCount = updatedCount)
        }
        prefs.sessionCount = updatedCount
    }

    fun languageSelected() {
        _state.update {
            it.copy(
                selectedLangCode = prefs.localeLanguageCode,
            )
        }
    }
}
