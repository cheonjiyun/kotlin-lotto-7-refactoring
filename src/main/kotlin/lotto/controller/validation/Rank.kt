package lotto.controller.validation

enum class Rank(private val countOfMatch: Int, private val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(3, 5_000),
    FIFTH(3, 5_000),
    OTHERS(0, 0);

    fun getCountOfMatch() = countOfMatch
    fun getWinningMoney() = winningMoney
}