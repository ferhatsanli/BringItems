import com.ferhat.bringitems.ProductCategory
import com.ferhat.bringitems.R
import kotlin.collections.listOf

enum class Product(
    val title: String,
    val imgId: Int = R.drawable.ic_launcher_foreground, //R.drawable.ic_launcher_foreground,
    val price: Float = 0.0f,
    val categories: List<ProductCategory> = listOf(ProductCategory.ALL)
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
    CHOCOLATE_COOKIE(
        title = "Chocolate Cookie",
        categories = listOf(
            ProductCategory.ALL,
            ProductCategory.DRINKS_REGISTER
        )
    ),

    // Drinks
    COCA_COLA(
        title = "Coca Cola",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    COCA_COLA_ZERO(
        title = "Coca Cola Zero",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    FANTA_ORANGE(
        title = "Fanta Orange",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    FANTA_EXOTIC(
        title = "Fanta Exotic",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    LIPTON_SPARKLING(
        title = "Lipton Sparkling",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    LIPTON_GREEN(
        title = "Lipton Green",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    WATER(
        title = "Water",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    SPRITE(
        title = "Sprite",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    FERNANDES_RED(
        title = "Fernandes Red",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    FERNANDES_GREEN(
        title = "Fernandes Green",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    WATER_SPARKLING(
        title = "Water (Sparkling)",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    CHOCOMELK(
        title = "Chocomelk",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    FRISTI(
        title = "Fristi",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),

    // Ingredients
    PEPPERONI(
        title = "Pepperoni",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    MOZARELLA(
        title = "Mozarella",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    TRIPLE_CHEESE(
        title = "Triple Cheese",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    GORGONZOLA(
        title = "Gorgonzola",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    CHEDDAR_PLAKS(
        title = "Cheddar Plaks",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    GRILLED_VEGGIE(
        title = "Grilled Veggie",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    JALAPENOS(
        title = "Jalapenos",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    HAM(
        title = "Ham",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    HETE_KIP(
        title = "Hete Kip",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    NATURAL_CHICKEN(
        title = "Natural Chicken",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    CHORIZO(
        title = "Chorizo",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),

    // Sides
    CHICKEN_POPS(
        title = "Chicken Pops",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    BUFFALO_WINGS(
        title = "Buffalo Wings",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),
    POTATO(
        title = "Potato",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS)
    ),
    CHICKEN_TENDERS(
        title = "Chicken Tenders",
        categories = listOf(ProductCategory.ALL, ProductCategory.CABINETS, ProductCategory.MEATS)
    ),

    // Sauce Bottles
    PESTO_SAUCE_BOTTLE(
        title = "Pesto Sauce Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    BUFFALO_SAUCE_BOTTLE(
        title = "Buffalo Sauce Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    SWEET_CHILI_BOTTLE(
        title = "Sweet Chili Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    PIRI_PIRI_BOTTLE(
        title = "Piri Piri Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    CHOPPED_GARLIC_BOTTLE(
        title = "Chopped Garlic Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    TRUFFLE_BOTTLE(
        title = "Truffle Bottle",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),

    // Sink Shelf/Drawers
    BUFFALO_MOZZARELLA(
        title = "Buffalo Mozzarella",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    LAVA_CAKE(
        title = "Lava Cake",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    OLD_AMSTERDAM(
        title = "Old Amsterdam",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    ONION(
        title = "Onion",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    MUSHROOM(
        title = "Mushroom",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    PAPRIKA(
        title = "Paprika",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    CHERRY_TOMATO(
        title = "Cherry Tomato",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),
    CREME_FRESH(
        title = "Creme Fresh",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRAWERS)
    ),

    // Sauce Packs
    KETCHUP(
        title = "Ketchup",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    SRIRACHA(
        title = "Sriracha",
        categories = listOf(ProductCategory.ALL, ProductCategory.BOTTLES)
    ),
    MAYO_PACKS(
        title = "Mayo packs",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    BBQ_PACKS(
        title = "BBQ packs",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    SWEET_CH_PACKS(
        title = "Sweet Ch. packs",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
    GARLIC_PACKS(
        title = "Garlic packs",
        categories = listOf(ProductCategory.ALL, ProductCategory.DRINKS_REGISTER)
    ),
}