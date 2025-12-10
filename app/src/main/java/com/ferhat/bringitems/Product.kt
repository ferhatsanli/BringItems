import com.ferhat.bringitems.R

enum class Product(
    val title: String,
    val imgId: Int = R.drawable.ic_launcher_foreground, //R.drawable.ic_launcher_foreground,
    val price: Float = 0.0f
) {
    /*
    * #Custom option !!!
    *
    * Chocolate Cookie
    *
    * #Drinks:
    * Coca Cola
    * Coca Cola Zero
    * Fanta Orange
    * Fanta Exotic
    * Lipton Sparkling
    * Lipton Green
    * Water
    * Sprite
    * Fernandes Red
    * Fernandes Green
    * Water (Sparkling)
    * Chocomelk
    * Fristi
    *
    * #Ingredients:
    * Pepperoni
    * Mozarella
    * Triple Cheese
    * Gorgonzola
    * Cheddar Plaks
    * Grilled Veggie
    * Jalapenos
    * Ham
    * Hete Kip
    * Natural Chicken
    * Chorizo
    *
    * #Sides:
    * Chicken Pops
    * Buffalo Wings
    * Potato
    * Chicken Tenders
    *
    * #Sauce Bottles:
    * Pesto Sauce Bottle
    * Buffalo Sauce Bottle
    * Sweet Chili Bottle
    * Piri Piri Bottle
    * Chopped Garlic Bottle
    * Truffle Bottle
    *
    * #Sink Shelf:
    * Buffalo Mozzarella
    * Lava Cake
    * Old Amsterdam
    * Onion
    * Mushroom
    * Paprika
    * Cherry Tomato
    * Creme Fresh
    *
    *
    * #Sauce Packs:
    * Ketchup
    * Sriracha
    * Mayo packs
    * BBQ packs
    * Sweet Ch. packs
    * Garlic packs
    * */
    CHOCOLATE_COOKIE(title = "Chocolate Cookie"),
    // Drinks
    COCA_COLA(title = "Coca Cola"),
    COCA_COLA_ZERO(title = "Coca Cola Zero"),
    FANTA_ORANGE(title = "Fanta Orange"),
    FANTA_EXOTIC(title = "Fanta Exotic"),
    LIPTON_SPARKLING(title = "Lipton Sparkling"),
    LIPTON_GREEN(title = "Lipton Green"),
    WATER(title = "Water"),
    SPRITE(title = "Sprite"),
    FERNANDES_RED(title = "Fernandes Red"),
    FERNANDES_GREEN(title = "Fernandes Green"),
    WATER_SPARKLING(title = "Water (Sparkling)"),
    CHOCOMELK(title = "Chocomelk"),
    FRISTI(title = "Fristi"),

    // Ingredients
    PEPPERONI(title = "Pepperoni"),
    MOZARELLA(title = "Mozarella"),
    TRIPLE_CHEESE(title = "Triple Cheese"),
    GORGONZOLA(title = "Gorgonzola"),
    CHEDDAR_PLAKS(title = "Cheddar Plaks"),
    GRILLED_VEGGIE(title = "Grilled Veggie"),
    JALAPENOS(title = "Jalapenos"),
    HAM(title = "Ham"),
    HETE_KIP(title = "Hete Kip"),
    NATURAL_CHICKEN(title = "Natural Chicken"),
    CHORIZO(title = "Chorizo"),

    // Sides
    CHICKEN_POPS(title = "Chicken Pops"),
    BUFFALO_WINGS(title = "Buffalo Wings"),
    POTATO(title = "Potato"),
    CHICKEN_TENDERS(title = "Chicken Tenders"),

    // Sauce Bottles
    PESTO_SAUCE_BOTTLE(title = "Pesto Sauce Bottle"),
    BUFFALO_SAUCE_BOTTLE(title = "Buffalo Sauce Bottle"),
    SWEET_CHILI_BOTTLE(title = "Sweet Chili Bottle"),
    PIRI_PIRI_BOTTLE(title = "Piri Piri Bottle"),
    CHOPPED_GARLIC_BOTTLE(title = "Chopped Garlic Bottle"),
    TRUFFLE_BOTTLE(title = "Truffle Bottle"),

    // Sink Shelf
    BUFFALO_MOZZARELLA(title = "Buffalo Mozzarella"),
    LAVA_CAKE(title = "Lava Cake"),
    OLD_AMSTERDAM(title = "Old Amsterdam"),
    ONION(title = "Onion"),
    MUSHROOM(title = "Mushroom"),
    PAPRIKA(title = "Paprika"),
    CHERRY_TOMATO(title = "Cherry Tomato"),
    CREME_FRESH(title = "Creme Fresh"),

    // Sauce Packs
    KETCHUP(title = "Ketchup"),
    SRIRACHA(title = "Sriracha"),
    MAYO_PACKS(title = "Mayo packs"),
    BBQ_PACKS(title = "BBQ packs"),
    SWEET_CH_PACKS(title = "Sweet Ch. packs"),
    GARLIC_PACKS(title = "Garlic packs"),
}