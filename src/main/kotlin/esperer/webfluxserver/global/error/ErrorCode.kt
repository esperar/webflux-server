package esperer.webfluxserver.global.error

enum class ErrorCode(
    val message: String,
    val statusCode: Int
) {

    EXPIRED_TOKEN("Expired Token",401),
    INVALID_TOKEN("Invalid Token", 401),
    NOT_FOUND_REQUEST_HANDLER("Not Found Request Handler", 404),
    UNAUTHORIZED("UNAUTHORIZED",401),
    INTERNAL_SERVER_ERROR("Internal server error", 500)
    ;

}