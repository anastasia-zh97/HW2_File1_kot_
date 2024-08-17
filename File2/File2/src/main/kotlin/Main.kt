package ru.Netology

fun main() {
    var transaction = 20000
    var allMonthTransactions = 80000
    countTax(allMonthTransactions, transaction)
}

fun countTax(allMonthTransactions: Int, transactionSum: Int, card: String = "МИР"): Int {
    var tax = 0
    val dayLimit = 150000
    val monthLimit = 600000
    val masterCardLimit = 75000
    if (card == "МИР") {
        if (transactionSum < dayLimit && (allMonthTransactions + transactionSum) < monthLimit) {
            println("Ваша комиссия состаляет " + tax + " руб")
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Mastercard" && allMonthTransactions > masterCardLimit
        && (allMonthTransactions + transactionSum) < monthLimit
    ) {
        if (transactionSum < dayLimit) {
            tax = (transactionSum * 0.006).toInt() + 20
            println("Ваша комиссия состаляет " + tax + " руб")
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Mastercard" && (allMonthTransactions + transactionSum) < masterCardLimit
        && (allMonthTransactions + transactionSum) < monthLimit
    ) {
        if (transactionSum < dayLimit) {
            println("Ваша комиссия состаляет " + tax + " руб")
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Mastercard" && (allMonthTransactions + transactionSum) > masterCardLimit
        && (allMonthTransactions + transactionSum) < monthLimit
    ) {
        if (transactionSum < dayLimit) {
            tax = (((allMonthTransactions + transactionSum) - masterCardLimit) * 0.006).toInt() + 20
            println("Ваша комиссия состаляет " + tax + " руб")
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Visa" && (allMonthTransactions + transactionSum) < monthLimit) {
        if (transactionSum < dayLimit) {
            tax = (transactionSum * 0.0075).toInt()
            if (tax < 35) {
                tax = 35
            }
            println("Ваша комиссия состаляет " + tax + " руб")
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    }
    return tax
}