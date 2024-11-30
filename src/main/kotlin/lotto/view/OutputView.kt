package lotto.view

import lotto.controller.validation.Rank
import java.text.DecimalFormat


class OutputView {

    fun printLottoNumbers(numbers: MutableList<List<Int>>) {
        println(numbers.size.toString() + LOTTO_COUNT_PRINT)
        numbers.forEach { println(it) }
    }

    private fun matchPrint(rank : Rank, matchNumber: Int){
        val moneyFormat = DecimalFormat("#,###")
        println("${rank.getCountOfMatch()}개 일치${if(rank == Rank.SECOND) ", 보너스 볼 일치" else ""} (${moneyFormat.format(rank.getWinningMoney())}원) - ${matchNumber}개")
    }
    fun printPrize(ranks : MutableMap<Rank, Int>, rate : Double) {
        println(PRIZE_PRINT)
        println(LINE_PRINT)
        val rateFormat = DecimalFormat("#0.0")
        for (rank in ranks){
            if(rank.key != Rank.OTHERS) matchPrint(rank.key, rank.value)
        }
        println("총 수익률은 ${rateFormat.format(rate)}%입니다.")
    }


    companion object {
        private const val LOTTO_COUNT_PRINT = "개를 구매했습니다."
        private const val PRIZE_PRINT = "당첨 통계"
        private const val LINE_PRINT = "---"
    }
}