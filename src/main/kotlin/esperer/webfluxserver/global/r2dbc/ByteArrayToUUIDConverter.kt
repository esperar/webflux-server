package esperer.webfluxserver.global.r2dbc

import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import java.nio.ByteBuffer
import java.util.*

@ReadingConverter
class ByteArrayToUUIDConverter : Converter<ByteArray, UUID> {

    override fun convert(source: ByteArray): UUID =
        ByteBuffer.wrap(source).run {
            UUID(this.long, this.long)
        }
}