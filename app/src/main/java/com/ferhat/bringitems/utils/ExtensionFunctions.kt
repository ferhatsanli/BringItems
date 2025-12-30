import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// the if block prevents -0.00 result, makes it 0.00
fun Float.to2Digits(): String = String.format("%.2f", if (this == 0.0f) 0.00f else this)

fun Int.toDp(): Dp = (this / (Resources.getSystem().displayMetrics.density)).dp