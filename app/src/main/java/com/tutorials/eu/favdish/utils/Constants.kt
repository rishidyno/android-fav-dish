package com.tutorials.eu.favdish.utils

// TODO Step 1: Create a Constants object in the utils package and define the constant values.
/**
 * This is used to define the constant values that we can use throughout the application.
 */
object Constants {

    const val DISH_TYPE: String = "DishType"
    const val DISH_CATEGORY: String = "DishCategory"
    const val DISH_COOKING_TIME: String = "DishCookingTime"

    const val DISH_IMAGE_SOURCE_LOCAL: String = "Local"
    const val DISH_IMAGE_SOURCE_ONLINE: String = "Online"

    const val EXTRA_DISH_DETAILS: String = "DishDetails"
    // START
    /**
     * This function will return the Dish Type List items.
     */
    fun dishTypes(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("breakfast")
        list.add("lunch")
        list.add("snacks")
        list.add("dinner")
        list.add("salad")
        list.add("side dish")
        list.add("dessert")
        list.add("other")
        return list
    }
    // END

    // START
    /**
     *  This function will return the Dish Category list items.
     */
    fun dishCategories(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("Pizza")
        list.add("BBQ")
        list.add("Bakery")
        list.add("Burger")
        list.add("Cafe")
        list.add("Chicken")
        list.add("Dessert")
        list.add("Drinks")
        list.add("Hot Dogs")
        list.add("Juices")
        list.add("Sandwich")
        list.add("Tea & Coffee")
        list.add("Wraps")
        list.add("Other")
        return list
    }
    // END


    // START
    /**
     *  This function will return the Dish Cooking Time list items. The time added is in Minutes.
     */
    fun dishCookTime(): ArrayList<String> {
        val list = ArrayList<String>()
        list.add("10")
        list.add("15")
        list.add("20")
        list.add("25")
        list.add("30")
        list.add("35")
        list.add("40")
        list.add("45")
        list.add("50")
        list.add("55")
        list.add("60")
        list.add("65")
        list.add("70")
        list.add("75")
        list.add("80")
        list.add("85")
        list.add("90")
        list.add("95")
        list.add("100")
        list.add("120")
        list.add("130")
        list.add("140")
        list.add("150")
        list.add("160")
        list.add("170")
        list.add("180")
        list.add("190")
        list.add("200")
        list.add("210")
        list.add("220")
        list.add("230")
        list.add("240")
        list.add("250")
        list.add("260")
        list.add("270")
        list.add("280")
        list.add("290")
        list.add("300")

        return list
    }
    // END
}