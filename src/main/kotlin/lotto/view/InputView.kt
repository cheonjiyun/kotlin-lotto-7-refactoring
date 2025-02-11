package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.validation.*

class InputView {
    private fun input(): String = Console.readLine()

    private fun checkChangeInt(input: String): Boolean {
        try {
            input.toInt()
            return true
        } catch (e: NumberFormatException) {
            println(ErrorType.NOT_NUMBER.errorMessage)
            throw IllegalArgumentException(ErrorType.NOT_NUMBER.errorMessage)
        }
    }

    fun getAmount(): Int {
        println(REQUEST_AMOUNT_MESSAGE);

        while (true) {
            val input = input()

            try {
                checkChangeInt(input)
                return input.toInt()

            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun getLottoNumbers(): List<Int> {
        println(REQUEST_NUMBERS_MESSAGE)

        while (true) {
            val lottoNumbers = input().split(',').map { it.toInt() }

            try {
                checkLottoNumbersCount(lottoNumbers)
                lottoNumbers.forEach {
                    isRangeLottoNumber(it)
                }
                return lottoNumbers
            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    fun getLottoBonusNumbers(inputNumbers : List<Int>): Int {
        println(REQUEST_BONUS_NUMBERS_MESSAGE)

        while (true) {
            val input = input()

            try {
                checkChangeInt(input)
                isRangeLottoNumber(input.toInt())
                checkDuplicationLottoAndBonus(inputNumbers, input.toInt())

                return input.toInt()

            } catch (e: IllegalArgumentException) {
                continue
            }
        }
    }

    companion object {
        private const val REQUEST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요. ${LOTTO_AMOUNT}원단위로 살 수 있습니다 \n 예) $LOTTO_AMOUNT"
        private const val REQUEST_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요."
        private const val REQUEST_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요."
    }
}