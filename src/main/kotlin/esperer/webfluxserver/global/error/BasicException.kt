package esperer.webfluxserver.global.error

import esperer.webfluxserver.global.error.attribute.ExceptionAttribute

abstract class BasicException(
    override val message: String,
    override val statusCode: Int
) : RuntimeException(message), ExceptionAttribute {
    override fun fillInStackTrace(): Throwable = this
}