package lotto.controller

import lotto.controller.validation.LOTTO_AMOUNT
import lotto.controller.validation.RandomNumber
import lotto.input
import lotto.lottoMaker
import lotto.model.Lotto
import lotto.model.LottoRound
import lotto.outputView

class LottoController {
    private val randomNumber = RandomNumber()

    fun run() {
        val inputAmount = input.getAmount()
        val lottos = makeLottos(inputAmount)

        val inputNumbers = input.getLottoNumbers()
        val inputBonusNumber = input.getLottoBonusNumbers()

        val lottoRound = LottoRound(lottos, inputNumbers, inputBonusNumber)
        val ranks = lottoRound.getRankCount()
        outputView.printPrize(ranks, lottoRound.getRate(inputAmount))
    }

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