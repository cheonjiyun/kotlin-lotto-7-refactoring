package lotto.util

import camp.nextstep.edu.missionutils.Randoms
import lotto.controller.validation.LOTTO_COUNT
import lotto.controller.validation.LOTTO_RANGE_CEIL
import lotto.controller.validation.LOTTO_RANGE_FLOOR

class RandomNumber {

    private fun randomLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_FLOOR, LOTTO_RANGE_CEIL, LOTTO_COUNT).sorted()
    }

    fun randomLottos(count: Int): MutableList<List<Int>> {
        val lottoNumbers = mutableListOf<List<Int>>()
        for (i in 1..count) {
            lottoNumbers.add(randomLotto())
        }
        return lottoNumbers
    }

}