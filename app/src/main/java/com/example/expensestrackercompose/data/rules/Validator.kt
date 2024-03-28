package com.example.expensestrackercompose.data.rules

object Validator {
    fun nameValidation(name: String): ValidationResult {
        return ValidationResult(
            (name.isNotEmpty() && name.length>=6)
        )
    }

    fun emailValidation(email: String): ValidationResult {
        return ValidationResult(
            (email.isNotEmpty() && email.length>=6)
        )
    }

    fun passwordValidation(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length>=6)
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)