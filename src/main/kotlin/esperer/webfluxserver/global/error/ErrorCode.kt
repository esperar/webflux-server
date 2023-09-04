package esperer.webfluxserver.global.error

enum class ErrorCode(
    val message: String,
    val statusCode: Int
) {

    EXPIRED_TOKEN("Expired Token",401),
    INVALID_TOKEN("Invalid Token", 401),
    USER_NOT_FOUND("User Not Found", 404),
    NOT_FOUND_REQUEST_HANDLER("Not Found Request Handler", 404),
    UNAUTHORIZED("UNAUTHORIZED",401),
    REFRESH_TOKEN_SAVE_FAILED("Failed to save RefreshToken", 500),
    INTERNAL_SERVER_ERROR("Internal server error", 500)
    ;
}