package lotto.controller.validation

enum class ErrorType(private val message: String){
    NOT_NUMBER("입력이 숫자가 아닙니다"),
    DUPLICATION_NUMBER("로또 번호가 중복입니다"),
    DUPLICATION_BONUS_NUMBER("보너스 번호가 로또 번호와 중복입니다"),
    NOT_RANGE_NUMBER("로또 번호가 유효범위가 아닙니다");



    val errorMessage: String
        get() = "$ERROR $message"
    companion object {
         private const val ERROR = "[ERROR]"
    }
}