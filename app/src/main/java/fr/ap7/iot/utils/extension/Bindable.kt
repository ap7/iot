package fr.ap7.iot.utils.extension

import androidx.databinding.BaseObservable

import fr.ap7.iot.BaseViewModel

class Bindable : BaseObservable() {

    internal var mValue: Boolean = false

    fun get(): Boolean {
        return mValue
    }

    fun set(value: Boolean) {
        if (mValue != value) {
            this.mValue = value
            notifyChange()
        }

    }
}
