package com.luisguzman.myapplication1.domain.model

sealed class DataItem {
    data class Header(val text: String) : DataItem()
    data class Item(val entries: Entries) : DataItem()
}
