import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/Input/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Multiplies the elements of the iterable by a double value.
 *
 * @param selector a function that maps each element of the iterable to an integer value.
 * @return the result of multiplying the mapped values together.
 * Returns 0 if the iterable is empty.
 */
public inline fun <T> Iterable<T>.multiplyByDouble(selector: (T) -> Int): Int {
    this.firstOrNull() ?: return 0
    var result = 1
    for (element in this) {
        result *= selector(element)
    }
    return result
}