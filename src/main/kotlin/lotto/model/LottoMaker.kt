package lotto.model

import lotto.controller.validation.LOTTO_AMOUNT
import lotto.controller.validation.RandomNumber
import lotto.view.Output

class LottoMaker {
    private val randomNumber = RandomNumber()
    private val output = Output()

    private fun getLottoCount(inputAmount : Int): Int {
        return inputAmount.div(LOTTO_AMOUNT)
    }

    fun makeLottos(inputAmount : Int): List<Lotto> {
        val lottoCount = getLottoCount(inputAmount)
        val lottoNumbers = randomNumber.randomLottos(lottoCount)

        output.printLottoNumbers(lottoNumbers)
        return lottoNumbers.map { Lotto(it) }
    }
}