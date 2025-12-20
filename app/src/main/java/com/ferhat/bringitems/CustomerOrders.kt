import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf

class CustomerOrders {
    private val orders = mutableStateMapOf<Product, Int>()
    private var totalPrice = mutableStateOf(0.0f)
    private var recentOrder = mutableStateOf(Product.COCA_COLA)
    private var recentOrderAmount = mutableStateOf(0)

    fun plus(product: Product, amount: Int = 1, updateRecentOrder: Boolean = false) {
        orders[product] = (orders[product] ?: 0) + amount
        totalPrice.value += product.price * amount
        if (updateRecentOrder) {
            recentOrder.value = product
            recentOrderAmount.value = orders[product] ?: 0
        }
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
            if (product == recentOrder.value)
                recentOrderAmount.value = orders[product] ?: 0
        }
    }

    fun clearAll() {
        orders.clear()
    }

    fun getRecentOrder(): Product = recentOrder.value

    fun getRecentOrderAmount(): Int = recentOrderAmount.value

    fun getTotal(): Float = totalPrice.value

    fun getOrders(): Map<Product, Int> = orders

    fun getOrdersList(): List<Pair<Product, Int>> = orders.toList()
}
