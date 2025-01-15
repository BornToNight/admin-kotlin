package ru.pachan.admin_kotlin

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAdminServer
class AdminKotlinApplication

fun main(args: Array<String>) {
    runApplication<AdminKotlinApplication>(*args)
}
