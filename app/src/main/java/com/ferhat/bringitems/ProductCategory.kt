package com.ferhat.bringitems

enum class ProductCategory {
    ALL,
    DRINKS_REGISTER {
        override fun toString(): String = "DRINKS & REGISTER"
    },
    CABINETS,
    DRAWERS,
    BOTTLES,
    MEATS;

    override fun toString(): String = name
}