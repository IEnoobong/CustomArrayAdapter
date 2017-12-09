/*
 * Copyright (c) 2017. Ibanga Enoobong Ime (World class developer and entrepreneur)
 */

package co.enoobong.customarrayadapter.model


class Computer(val make: String, val model: String, val serialNumber: String){

    override fun toString(): String {
        //wrong use of toString
        return make
    }
}

class Hotel(val name: String, val address: String, val hasPool: Boolean, val hasWifi: Boolean){

    override fun toString(): String {
        return "Hotel(name='$name', address='$address', hasPool=$hasPool, hasWifi=$hasWifi)"
    }

}

class Chair(val make: String, val model: String, val type: String): ModelDisplayName{

    override val displayName get() = make

    override fun toString(): String {
        //Correct use of toString
        return "Chair(make='$make', model='$model', type='$type')"
    }


}