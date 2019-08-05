package com.peter.aneke.travelmantics

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InputViewModel(application: Application) : AndroidViewModel(application) {

    val firebaseDb: FirebaseDatabase by lazy { FirebaseDatabase.getInstance() }
    val databaseReference: DatabaseReference by lazy { firebaseDb.reference.child("traveldeals") }

    val eventName = MutableLiveData<String>()

    val eventPrice = MutableLiveData<String>()

    val eventDesc = MutableLiveData<String>()

    val errorMessage = MutableLiveData<String>()

    val success = MutableLiveData<Boolean>()


    fun save() {
        if (validateFields()) {
            errorMessage.value = "${eventName.value} saved"
            databaseReference.push().setValue(
                TravelDeal(
                    desc = eventDesc.value!!,
                    title = eventName.value!!,
                    price = eventPrice.value!!

                )
            )
            success.value = true
        }
    }


    private fun validateFields(): Boolean {
        if (eventName.value.isNullOrBlank()) {
            errorMessage.value = "Event Name cannot be blank"
            return false
        }
        if (eventPrice.value.isNullOrBlank()) {
            errorMessage.value = "Event Price cannot be blank"
            return false
        }
        if (eventDesc.value.isNullOrBlank()) {
            errorMessage.value = "Event Description cannot be blank"
            return false
        }
        return true
    }


}