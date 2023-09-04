package esperer.webfluxserver.global.error.attribute

interface ExceptionAttribute {
    val message: String
    val statusCode: Int
}