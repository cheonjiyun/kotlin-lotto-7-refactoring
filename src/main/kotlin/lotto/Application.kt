package lotto

import lotto.controller.LottoController
import lotto.util.RandomNumber
import lotto.view.InputView
import lotto.view.OutputView

val randomNumber = RandomNumber()
val inputView = InputView()
val outputView = OutputView()

fun main() {
    val lottoController = LottoController(inputView, randomNumber)
    lottoController.run()
}
