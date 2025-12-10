import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf

class CustomerOrders {
    private val orders = mutableStateMapOf<Product, Int>()
    private var totalPrice = mutableStateOf(0.0f)

    fun plus(product: Product, amount: Int = 1) {
        orders[product] = (orders[product] ?: 0) + amount
        totalPrice.value += product.price * amount
    }

    fun minus(product: Product, amount: Int = 1) {
        orders[product]?.let {
            if (it > 1) {
                orders[product] = it - amount
            }
            if (it == amount || it == 0){
                orders.remove(product)
            }
            totalPrice.value -= product.price * amount
        }
    }

    fun getTotal(): Float = totalPrice.value

    fun getOrders(): Map<Product, Int> = orders

    fun getOrdersList(): List<Pair<Product, Int>> = orders.toList()
}
