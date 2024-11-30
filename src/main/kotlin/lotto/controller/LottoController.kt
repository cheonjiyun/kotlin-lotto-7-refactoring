package lotto.controller

import lotto.controller.validation.LOTTO_AMOUNT
import lotto.controller.validation.checkDuplicationLottoAndBonus
import lotto.util.RandomNumber
import lotto.model.Lotto
import lotto.model.LottoRound
import lotto.outputView
import lotto.view.InputView

class LottoController(private val inputView: InputView, private val randomNumber: RandomNumber) {

    fun run() {
        val inputAmount = inputView.getAmount()
        val lottoNumbers = makeLottoNumbers(inputAmount)
        outputView.printLottoNumbers(lottoNumbers)
        val lottos = makeLottos(lottoNumbers)

        val inputNumbers = inputView.getLottoNumbers()
        val inputBonusNumber = inputView.getLottoBonusNumbers()
        checkDuplicationLottoAndBonus(inputNumbers, inputBonusNumber)

        val lottoRound = LottoRound(lottos, inputNumbers, inputBonusNumber)
        val ranks = lottoRound.getRankCount()
        outputView.printPrize(ranks, lottoRound.getRate(inputAmount))
    }

    private fun getLottoCount(inputAmount : Int): Int {
        return inputAmount.div(LOTTO_AMOUNT)
    }

    private fun makeLottoNumbers(inputAmount : Int): MutableList<List<Int>> {
        val lottoCount = getLottoCount(inputAmount)
        return randomNumber.randomLottos(lottoCount)
    }

    private fun makeLottos(lottoNumbers: MutableList<List<Int>>): List<Lotto> {
        return lottoNumbers.map { Lotto(it) }
    }
}