package esperer.webfluxserver.global.r2dbc

import esperer.webfluxserver.global.converter.ByteArrayToUUIDConverter
import esperer.webfluxserver.global.converter.UUIDToByteArrayConverter
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@Configuration
class R2dbcConfiguration(
    private val connectionFactory: ConnectionFactory
) : AbstractR2dbcConfiguration() {

    @Bean
    fun init() = ConnectionFactoryInitializer().apply {
        setConnectionFactory(connectionFactory)
        setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
    }

    override fun connectionFactory(): ConnectionFactory = connectionFactory
    override fun getCustomConverters() = listOf(UUIDToByteArrayConverter(), ByteArrayToUUIDConverter())
}