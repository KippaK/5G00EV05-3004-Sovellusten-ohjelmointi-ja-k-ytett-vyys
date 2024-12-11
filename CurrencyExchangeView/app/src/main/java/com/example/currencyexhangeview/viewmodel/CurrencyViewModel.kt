package com.example.currencyexhangeview.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL

class CurrencyViewModel : ViewModel() {
    private val apiUrl = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1"
    val currencies = mutableStateOf<Map<String, String>>(emptyMap())
    val exchangeRates = mutableStateOf<Map<String, Double>>(emptyMap())

    init {
        viewModelScope.launch {
            fetchCurrencies()
            fetchExchangeRates()
        }
    }

    private suspend fun fetchCurrencies() {
        val result = URL("$apiUrl/currencies.json").readText()
        currencies.value = JSONObject(result).toMap() as Map<String, String>
    }

    private suspend fun fetchExchangeRates() {
        val result = URL("$apiUrl/currencies/eur.json").readText()
        val jsonObject = JSONObject(result).getJSONObject("eur")
        exchangeRates.value = jsonObject.toMap() as Map<String, Double>
    }

    private fun JSONObject.toMap(): Map<String, Any> = keys().asSequence().associateWith { get(it) }
}