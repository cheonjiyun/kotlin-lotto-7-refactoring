package lotto.model

import lotto.controller.validation.LOTTO_AMOUNT
import lotto.controller.validation.RandomNumber
import lotto.view.OutputView

class LottoMaker {
    private val randomNumber = RandomNumber()
    private val outputView = OutputView()

    private fun getLottoCount(inputAmount : Int): Int {
        return inputAmount.div(LOTTO_AMOUNT)
    }

    fun makeLottos(inputAmount : Int): List<Lotto> {
        val lottoCount = getLottoCount(inputAmount)
        val lottoNumbers = randomNumber.randomLottos(lottoCount)

        outputView.printLottoNumbers(lottoNumbers)
        return lottoNumbers.map { Lotto(it) }
    }
}