package com.payment.api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig() {

    @Value("\${swagger.host}")
    private val host: String? = null

    @Value("\${swagger.base.path}")
    private val basePath: String? = null

    @Value("\${swagger.api.title}")
    private val apiTile: String? = null

    @Value("\${swagger.api.description}")
    private val apiDescription: String? = null

    @Value("\${swagger.api.version}")
    private val apiVersion: String? = null

    @Value("\${swagger.api.contact.name}")
    private val contactName: String? = null

    @Value("\${swagger.api.contact.url}")
    private val contactUrl: String? = null

    @Value("\${swagger.api.contact.email}")
    private val contactEmail: String? = null

    @Bean
    fun myOpenAPI(): OpenAPI {
        val server = Server()
        server.url = "$host$basePath"
        server.description = apiDescription

        val contact: Contact = Contact()
        contact.url = contactUrl
        contact.name = contactName
        contact.email = contactEmail

        val info: Info = Info()
            .title(apiTile)
            .version(apiVersion)
            .contact(contact)
            .description(apiDescription)

        return OpenAPI().info(info).servers(listOf(server))
    }
}