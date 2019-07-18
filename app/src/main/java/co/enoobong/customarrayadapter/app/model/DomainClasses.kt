/*
 * Copyright (c) 2017. Ibanga Enoobong Ime (World class developer and entrepreneur)
 */

package co.enoobong.customarrayadapter.app.model

import co.enoobong.customarrayadapter.lib.model.ModelDisplayName


class Computer(private val make: String, val model: String, val serialNumber: String) {

    override fun toString(): String {
        //wrong use of toString
        return make
    }
}

class Hotel(val name: String, private val address: String, private val hasPool: Boolean, private val hasWifi: Boolean) {

    override fun toString(): String {
        return "Hotel(name='$name', address='$address', hasPool=$hasPool, hasWifi=$hasWifi)"
    }

}

class Chair(private val make: String, private val model: String, private val type: String) :
    ModelDisplayName {

    override val displayName get() = make

    override fun toString(): String {
        //Correct use of toString
        return "Chair(make='$make', model='$model', type='$type')"
    }
}

class Phone(val make: String, val model: String, val is4gEnabled: Boolean) //No toString
