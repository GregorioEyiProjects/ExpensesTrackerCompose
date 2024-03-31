package com.example.expensestrackercompose.data

sealed class UIEvents {

    data class NameChange(val name:String) : UIEvents()
    data class EmailChange(val email:String) : UIEvents()
    data class PasswordChange(val password:String) : UIEvents()
    data class PrivacyPolicyChecked(val status:Boolean):UIEvents()
     object RegisterButtonClicked: UIEvents()
     object LoginButtonClicked: UIEvents()

}