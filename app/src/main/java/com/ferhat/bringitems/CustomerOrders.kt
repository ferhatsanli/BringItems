import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlin.collections.sortedBy
import java.io.Serializable

val TAG = "BAKBURA"
class CustomerOrders : Serializable {
    private val orders = mutableStateMapOf<Product, Int>()
    @Transient private var totalPrice = mutableStateOf(0.0f)
    @Transient private var recentOrder = mutableStateOf(Product.COCA_COLA)
    @Transient private var recentOrderAmount = mutableStateOf(0)

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
            if (it == amount || it == 0) {
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

    fun getSize(): Int = orders.size
    fun getOrders(): Map<Product, Int> = orders

    fun getOrdersList(): List<Pair<Product, Int>> = orders.toList()

    fun getSortedOrdersList(): List<Pair<Product, Int>> = getOrdersList()
        .sortedBy { it.first.name }
        .groupBy { it.first.categories }
        .entries
        .sortedBy { it.key.first() }
        .flatMap { it.value }

    fun saveToPreferences(context: Context) {
        if (orders.size > 0) {
            val prefs: SharedPreferences =
                context.getSharedPreferences("orders", Context.MODE_PRIVATE)
            val gson = Gson()
            val json = gson.toJson(this)
            prefs.edit().putString("order_list", json).apply()
        }
    }

    companion object {
        fun loadFromPreferences(context: Context): CustomerOrders {
            val prefs: SharedPreferences =
                context.getSharedPreferences("orders", Context.MODE_PRIVATE)
            Log.i(TAG, "loadFromPreferences: prefs done")
            val gson = Gson()
            Log.i(TAG, "loadFromPreferences: gson done")
            val json = prefs.getString("order_list", null)
            Log.i(TAG, "loadFromPreferences: json >> $json")
            return if (json != null) gson.fromJson(
                json,
                CustomerOrders::class.java
            ) else CustomerOrders()
        }
    }
}
