package com.example.recyclerview

import kotlin.random.Random

data class Fruits(val name: String, val origin: String, val quantity: Int) {

    companion object {
        @JvmField
        val FRUIT_NAMES = arrayOf("apple", "mango", "orange", "pineapple")

        @JvmField
        val ORIGINS = arrayOf("lucknow", "nagpur", "mysore", "srinagar")


        @JvmStatic
        fun genRandomFruits(n: Int): ArrayList<Fruits> {
            val fruitArray = ArrayList<Fruits>(n)
            for (i in 1..n) {
                fruitArray.add(
                    Fruits(
                        FRUIT_NAMES[Random.nextInt(4)],
                        ORIGINS[Random.nextInt(4)],
                        Random.nextInt(10) * 100
                    )
                )
            }
            return fruitArray
        }
    }
}