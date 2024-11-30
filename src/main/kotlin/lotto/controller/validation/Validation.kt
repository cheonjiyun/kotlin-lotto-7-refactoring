package lotto.controller.validation


fun checkLottoNumbersCount(lottoNumbers: List<Int>) {
    if(!lottoNumbers.size.equals(LOTTO_COUNT)){
        println(ErrorType.LOTTO_NUMBER_SIZE.errorMessage)
        throw IllegalArgumentException(ErrorType.LOTTO_NUMBER_SIZE.errorMessage)
    }
}

fun isDuplicationLottoNumbers(lottoNumbers: List<Int>): Boolean {
    val duplicationNumbers = lottoNumbers.filterIndexed { idx, it -> lottoNumbers.indexOf(it) != idx }
    if (duplicationNumbers.isNotEmpty()) {
        println(ErrorType.DUPLICATION_NUMBER.errorMessage)
        return false
    }
    return true
}

fun checkDuplicationLottoAndBonus(lottoNumbers: List<Int>, bonusNumber: Int) {
    if (lottoNumbers.contains(bonusNumber)) {
        println(ErrorType.DUPLICATION_BONUS_NUMBER.errorMessage)
        throw IllegalArgumentException(ErrorType.DUPLICATION_BONUS_NUMBER.errorMessage)
    }
}


fun isRangeLottoNumber(number: Int): Boolean {
    if (number < LOTTO_RANGE_FLOOR || number > LOTTO_RANGE_CEIL) {
        println(ErrorType.NOT_RANGE_NUMBER)
        return false
    }
    return true
}
