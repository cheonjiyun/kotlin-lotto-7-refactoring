package lotto.model

import lotto.controller.validation.Rank

class LottoRound(private val lottos: List<Lotto>, private val numbers: List<Int>, private val bonusNumber: Int) {

    fun getRankCount(): MutableMap<Rank, Int> {
        val rankCount = mutableMapOf(
            Rank.OTHERS to 0,
            Rank.FIFTH to 0,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 0,
            Rank.FIRST to 0
        )

        lottos.forEach { lotto ->
            val rank = lotto.getRank(numbers, bonusNumber)
            rankCount[rank] = rankCount[rank]!! + 1
        }

        return rankCount
    }

    private fun getTotalPrize(rankCount: MutableMap<Rank, Int>): Int {
        var totalPrize = 0
        rankCount.forEach {
            totalPrize += it.key.getWinningMoney().times((it.value))
        }
        return totalPrize
    }

    fun getRate(amount: Int): Double {
        val rankCount = getRankCount()
        val totalPrize = getTotalPrize(rankCount)

        return ((totalPrize).toDouble() / amount.toDouble()) * 100
    }

}