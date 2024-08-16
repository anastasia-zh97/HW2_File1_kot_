package ru.Netology

fun main() {
    var message = ""
    val secondsValue = 51
    val minutesValue = secondsValue / 60
    val hoursValue = (secondsValue / 60) / 60


    when (secondsValue) {
        in 0..60 -> message = "был(а) только что"
        in 61..3600 -> message = "был(а) " + minutesValue + " " + chooseMinuteEnding(minutesValue) + " назад"
        in 2601..86400 -> message = "был(а) " + hoursValue + " " + chooseHourEnding(hoursValue) + " назад"
        in 86401..172800 -> message = "был(а) вчера"
        in 172801..259200 -> message = "был(а) позавчера"
        else -> "был(а) давно"
    }

    print(message)
}

fun chooseMinuteEnding(minutes: Int): String {
    var result = ""
    when (minutes % 100) {
        1 -> result = "минуту"
        in 5..19 -> result = "минут"
        in 20..60 step 10 -> result = "минут"
        in 21..51 step 10 -> result = "минуту"
        in 22..52 step 10 -> result = "минуты"
        in 23..53 step 10 -> result = "минуты"
        in 24..54 step 10 -> result = "минуты"
        in 25..55 step 10 -> result = "минут"
        in 26..56 step 10 -> result = "минут"
        in 27..57 step 10 -> result = "минут"
        in 28..58 step 10 -> result = "минут"
        in 29..59 step 10 -> result = "минут"
        else -> result = "минуты"
    }
    return result
}

fun chooseHourEnding(hours: Int): String {
    var result = ""
    when (hours % 100) {
        in 1..21 step 20 -> result = "час"
        in 2..4 -> result = "часа"
        in 5..20 -> result = "часов"
        in 22..24 -> result = "часа"
        else -> result = "час"
    }
    return result
}