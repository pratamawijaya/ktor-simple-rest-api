package pratamawijaya.com

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import pratamawijaya.com.plugins.*
import pratamawijaya.com.routes.customerRouting
import pratamawijaya.com.routes.getOrderRoute
import pratamawijaya.com.routes.listOrdersRoute
import pratamawijaya.com.routes.totalizeOrderRoute

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    configureRouting()
    configureSerialization()
}

fun Application.configureRouting() {
    routing {
        customerRouting()
        listOrdersRoute()
        getOrderRoute()
        totalizeOrderRoute()
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
