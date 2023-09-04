package esperer.webfluxserver.domain.auth.exception

import esperer.webfluxserver.global.error.BasicException
import esperer.webfluxserver.global.error.ErrorCode

class RefreshTokenSaveFailedException : BasicException(ErrorCode.REFRESH_TOKEN_SAVE_FAILED.message, ErrorCode.REFRESH_TOKEN_SAVE_FAILED.statusCode)