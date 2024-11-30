package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView

val input = InputView()
val outputView = OutputView()

fun main() {
    val lottoController = LottoController()
    lottoController.run()
}
