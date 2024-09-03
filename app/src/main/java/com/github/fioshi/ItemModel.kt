package com.github.fioshi

data class ItemModel(
    val id : Long,
    val name: String,
    val onRemove: (ItemModel) -> Unit)