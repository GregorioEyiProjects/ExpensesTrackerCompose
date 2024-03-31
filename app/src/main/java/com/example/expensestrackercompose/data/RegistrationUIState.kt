package com.example.expensestrackercompose.data

data class RegistrationUIState(
    var name:String = "",
    var email:String= "",
    var password:String= "",
    var privacyPolicyRead:Boolean = false,
    var nameError:Boolean = false,
    var emailError:Boolean = false,
    var passwordError:Boolean = false,
    var privacyPolicyError: Boolean = false
)