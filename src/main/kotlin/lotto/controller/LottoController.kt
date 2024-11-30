package lotto.controller

import lotto.input
import lotto.lottoMaker
import lotto.model.LottoRound
import lotto.outputView

class LottoController {
    fun run() {
        val inputAmount = input.getAmount()
        val lottos = lottoMaker.makeLottos(inputAmount)

        val inputNumbers = input.getLottoNumbers()
        val inputBonusNumber = input.getLottoBonusNumbers()

        val lottoRound = LottoRound(lottos, inputNumbers, inputBonusNumber)
        val ranks = lottoRound.getRankCount()
        outputView.printPrize(ranks, lottoRound.getRate(inputAmount))
    }
}