package esperer.webfluxserver.global.config

import esperer.webfluxserver.global.security.SecurityProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        SecurityProperties::class
    ]
)
@Configuration
class PropertiesScanConfiguration