package com.urooj.recipecalculator

enum class Ingredients(val ingredientName: String) {
    EGG("Egg"),
    CREAM("Cream"),
    BANANA("Banana"),
    MANGO("Mango"),
    OREO("Oreo"),
    FLOUR("Flour"),
    MARBLE_CAKE("Marble Cake"),
    NUTELLA("Nutella"),
    CHOCOLATE("Chocolate"),
    COFFEE("Coffee"),
    PLUS("+")
}

enum class Deserts(val desertName: String) {
    CHOCOLATE_SOUFFLE("Chocolate Souffle"),
    BANANA_PANCAKES("Banana Pancakes"),
    COFFEE_CAKE("Coffee Cake"),
    MANGO_MOUSSE("Mango Mousse"),
    OREO_BARK("Oreo Bark"),
    NUTELLA_COOKIES("Nutella Cookies"),
    NONE("")
}

fun calculate(ingredients: List<Ingredients>): Deserts {
    return when (ingredients.size) {
        3 -> createDesertWithTwoIngredients(ingredients)
        5 -> createDesertWithThreeIngredients(ingredients)
        else -> Deserts.NONE
    }
}

private fun createDesertWithTwoIngredients(ingredients: List<Ingredients>): Deserts {
    if (ingredients.size == 3) {
        if (ingredients[1] == Ingredients.PLUS) {
            val firstIngredient = ingredients[0]
            val secondIngredient = ingredients[2]
            if (firstIngredient == Ingredients.EGG || secondIngredient == Ingredients.EGG) {
                return createDesertWithEgg(firstIngredient, secondIngredient)
            }
            if (firstIngredient == Ingredients.MANGO || secondIngredient == Ingredients.MANGO) {
                return createMangoMousse(firstIngredient, secondIngredient)
            }
            if (firstIngredient == Ingredients.OREO || secondIngredient == Ingredients.OREO) {
                return createOreoBark(firstIngredient, secondIngredient)
            }
            if (firstIngredient == Ingredients.FLOUR || secondIngredient == Ingredients.FLOUR) {
                return createNutellaCookies(firstIngredient, secondIngredient)
            }
        }
    }
    return Deserts.NONE
}

private fun createDesertWithThreeIngredients(ingredients: List<Ingredients>): Deserts {
    if (ingredients.size == 5) {
        if (ingredients[1] == Ingredients.PLUS && ingredients[3] == Ingredients.PLUS) {
            val firstIngredient = ingredients[0]
            val secondIngredient = ingredients[2]
            val thirdIngredient = ingredients[4]
            if (firstIngredient == Ingredients.MARBLE_CAKE
                && secondIngredient == Ingredients.COFFEE
                && thirdIngredient == Ingredients.CREAM
            ) {
                return Deserts.COFFEE_CAKE
            }
            if (firstIngredient == Ingredients.CREAM
                && secondIngredient == Ingredients.MARBLE_CAKE
                && thirdIngredient == Ingredients.COFFEE
            ) {
                return Deserts.COFFEE_CAKE
            }
            if (firstIngredient == Ingredients.COFFEE
                && secondIngredient == Ingredients.CREAM
                && thirdIngredient == Ingredients.MARBLE_CAKE
            ) {
                return Deserts.COFFEE_CAKE
            }
        }
    }
    return Deserts.NONE
}

private fun createDesertWithEgg(firstIngredient: Ingredients, secondIngredient: Ingredients): Deserts {
    if (firstIngredient == Ingredients.EGG && secondIngredient == Ingredients.CHOCOLATE) {
        return Deserts.CHOCOLATE_SOUFFLE
    }
    if (firstIngredient == Ingredients.CHOCOLATE && secondIngredient == Ingredients.EGG) {
        return Deserts.CHOCOLATE_SOUFFLE
    }
    if (firstIngredient == Ingredients.EGG && secondIngredient == Ingredients.BANANA) {
        return Deserts.BANANA_PANCAKES
    }
    if (firstIngredient == Ingredients.BANANA && secondIngredient == Ingredients.EGG) {
        return Deserts.BANANA_PANCAKES
    }
    return Deserts.NONE
}

private fun createMangoMousse(firstIngredient: Ingredients, secondIngredient: Ingredients): Deserts {
    if (firstIngredient == Ingredients.MANGO && secondIngredient == Ingredients.CREAM) {
        return Deserts.MANGO_MOUSSE
    }
    if (firstIngredient == Ingredients.CREAM && secondIngredient == Ingredients.MANGO) {
        return Deserts.MANGO_MOUSSE
    }
    return Deserts.NONE
}

private fun createOreoBark(firstIngredient: Ingredients, secondIngredient: Ingredients): Deserts {
    if (firstIngredient == Ingredients.OREO && secondIngredient == Ingredients.CHOCOLATE) {
        return Deserts.OREO_BARK
    }
    if (firstIngredient == Ingredients.CHOCOLATE && secondIngredient == Ingredients.OREO) {
        return Deserts.OREO_BARK
    }
    return Deserts.NONE
}

private fun createNutellaCookies(firstIngredient: Ingredients, secondIngredient: Ingredients): Deserts {
    if (firstIngredient == Ingredients.FLOUR && secondIngredient == Ingredients.NUTELLA) {
        return Deserts.NUTELLA_COOKIES
    }
    if (firstIngredient == Ingredients.NUTELLA && secondIngredient == Ingredients.FLOUR) {
        return Deserts.NUTELLA_COOKIES
    }
    return Deserts.NONE
}
