package com.example.networkinginkotlin

data class UserResponse(
	val totalCount: Int? =null,
	val incompleteResults: Boolean? = null,
	val items: List<User>? =null
)

