package app.petermiklanek.currency.tools.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import timber.log.Timber

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}

fun Fragment.navigateTo(navDirections: NavDirections, options: NavOptions? = null) = try {
    findNavController().navigate(navDirections, options)
} catch (e: Exception) {
    Timber.e(e)
}

fun Fragment.navigateBack() = findNavController().navigateUp()
