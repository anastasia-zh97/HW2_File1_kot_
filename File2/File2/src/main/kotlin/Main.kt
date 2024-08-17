package ru.Netology

fun main() {
    val monthLimitForMasterCard = 75000
    var transaction = 1000
    val cardType = "Visa"

    countTax(cardType, monthLimitForMasterCard, transaction);
}

fun countTax(card: String, allMonthTransactions: Int, transactionSum: Int): Int {
    var tax = 0
    val dayLimit = 150000
    val monthLimit = 600000
    var monthExpenses = 0
    var dayExpenses = 0
    if (card == "МИР") {
        if (transactionSum < dayLimit && (monthExpenses + transactionSum) < monthLimit &&
            (dayExpenses + transactionSum) < dayLimit
        ) {
            println("Ваша комиссия состаляет " + tax + " руб")
            monthExpenses += transactionSum
            dayExpenses += transactionSum
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Mastercard" && transactionSum < allMonthTransactions) {
        if (transactionSum < dayLimit && (monthExpenses + transactionSum) < monthLimit &&
            (dayExpenses + transactionSum) < dayLimit
        ) {
            println("Ваша комиссия состаляет " + tax + " руб")
            monthExpenses += transactionSum
            dayExpenses += transactionSum
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Mastercard" && transactionSum > allMonthTransactions) {
        if (transactionSum < dayLimit && (monthExpenses + transactionSum) < monthLimit &&
            (dayExpenses + transactionSum) < dayLimit
        ) {
            tax = ((transactionSum - allMonthTransactions) * 0.06).toInt() + 20
            println("Ваша комиссия состаляет " + tax + " руб")
            monthExpenses += transactionSum
            dayExpenses += transactionSum
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    } else if (card == "Visa") {
        if (transactionSum < dayLimit && (monthExpenses + transactionSum) < monthLimit &&
            (dayExpenses + transactionSum) < dayLimit
        ) {
            tax = (transactionSum * 0.075).toInt()
            if (tax < 35) {
                tax = 35
            }
            println("Ваша комиссия состаляет " + tax + " руб")
            monthExpenses += transactionSum
            dayExpenses += transactionSum
        } else {
            println("Перевод не может быть произведен, поскольку привышен лимит")
        }
    }
    return tax
}