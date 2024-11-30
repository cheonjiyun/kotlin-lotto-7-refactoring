package lotto.controller.validation

enum class ErrorType(private val message: String){
    NOT_NUMBER("[ERROR] 입력이 숫자가 아닙니다"),
    DUPLICATION_NUMBER("[ERROR] 로또 번호가 중복입니다"),
    NOT_RANGE_NUMBER("[ERROR] 로또 번호가 유효범위가 아닙니다");

    val errorMessage: String
        get() = ERROR + message
    companion object {
         private const val ERROR = "[ERROR]"
    }
}