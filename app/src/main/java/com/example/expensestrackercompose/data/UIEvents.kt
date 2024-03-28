package com.example.expensestrackercompose.data

sealed class UIEvents {



    data class NameChange(val name:String) : UIEvents()
    data class EmailChange(val email:String) : UIEvents()
    data class PasswordChange(val password:String) : UIEvents()
    object RegisterButtonClicked: UIEvents()

}