package lotto

import lotto.controller.LottoController
import lotto.model.LottoMaker
import lotto.model.LottoRound
import lotto.view.InputView
import lotto.view.OutputView

val input = InputView()
val outputView = OutputView()
val lottoMaker = LottoMaker()

fun main() {
    val lottoController = LottoController()
    lottoController.run()
}
