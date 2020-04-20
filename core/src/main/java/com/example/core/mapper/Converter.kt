package com.example.core.mapper

interface Converter<out T, in F> {
    fun convert(item: F): T
}