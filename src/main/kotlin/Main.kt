fun main() {
    val time = 12490
    println(agoToText(time))
}

fun agoToText(time: Int): String {
    return when (time) {
        in 0..60 -> "был(а) в сети только что"
        in 61..60 * 60 -> agoToMinute(time)
        in 60 * 60 + 1..24 * 60 * 60 -> agoToHour(time)
        in 24 * 60 * 60 + 1..24 * 60 * 60 * 2 -> "был(а) в сети вчера"
        in 24 * 60 * 60 * 2 + 1..24 * 60 * 60 * 3 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun agoToMinute(time: Int): String {
    return when (time/60) {
        1, 21, 31, 41, 51 -> "был(а) в сети ${time/60} минуту назад"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "был(а) в сети ${time/60} минуты назад"
        else -> "был(а) в сети ${time/60} минут назад"
    }
}

fun agoToHour(time: Int): String {
    return when (time/60/60) {
        1, 21 -> "был(а) в сети ${time/60/60} час назад"
        2, 3, 4, 22, 23, 24 -> "был(а) в сети ${time/60/60} часа назад"
        else -> "был(а) в сети $time часов назад"
    }
}