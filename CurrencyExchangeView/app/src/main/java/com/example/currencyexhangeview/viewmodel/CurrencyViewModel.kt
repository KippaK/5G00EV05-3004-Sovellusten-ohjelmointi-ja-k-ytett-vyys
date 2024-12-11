package com.example.currencyexhangeview.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class CurrencyViewModel : ViewModel() {
    private val apiUrl = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1"
    var currencies by mutableStateOf<Map<String, String>>(emptyMap())
        private set
    var exchangeRates by mutableStateOf<Map<String, Double>>(emptyMap())
        private set

    init {
        viewModelScope.launch {
            fetchCurrencies()
            fetchExchangeRates()
        }
    }

    private suspend fun fetchCurrencies() {
        val result = withContext(Dispatchers.IO) {
            URL("$apiUrl/currencies.json").readText()
        }
        currencies = JSONObject(result).toMap() as Map<String, String>
    }

    private suspend fun fetchExchangeRates() {
        val result = withContext(Dispatchers.IO) {
            URL("$apiUrl/currencies/eur.json").readText()
        }
        val jsonObject = JSONObject(result).getJSONObject("eur")
        exchangeRates = jsonObject.toMap() as Map<String, Double>
    }

    private fun JSONObject.toMap(): Map<String, Any> = keys().asSequence().associateWith { get(it) }
}