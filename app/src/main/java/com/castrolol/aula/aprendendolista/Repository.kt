package com.castrolol.aula.aprendendolista

data class Repository(
    var name: String = "",
    var fullName: String = "",
    var fork: Boolean = false,
    var language: String  = "",
    var stargazers_count: Int = 0
)