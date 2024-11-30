package lotto.model

import lotto.controller.validation.*


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require( isDuplicationLottoNumbers(numbers)) { ErrorType.DUPLICATION_NUMBER }
        numbers.forEach { require(isRangeLottoNumber(it)) { ErrorType.NOT_RANGE_NUMBER } }
    }

    private fun switchRank(matchNumberSize: Int, isBonusNumberMatch: Boolean): Rank {
        if (matchNumberSize == 6) return Rank.FIRST
        if (matchNumberSize == 5 && isBonusNumberMatch) return Rank.SECOND
        if (matchNumberSize == 5) return Rank.THIRD
        if (matchNumberSize == 4) return Rank.FOURTH
        if (matchNumberSize == 3) return Rank.FIFTH
        return Rank.OTHERS
    }

    fun getRank(lottoNumbers: List<Int>, bonusNumber: Int): Rank {
        val count = numbers.filter { number -> lottoNumbers.any { it == number } }
        val isBonusNumberMatch = numbers.any { it == bonusNumber }

        return switchRank(count.size, isBonusNumberMatch)
    }
}
