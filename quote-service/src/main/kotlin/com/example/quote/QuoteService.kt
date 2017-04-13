package com.example.quote

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class QuoteService

fun main(args: Array<String>) {
    SpringApplication.run(QuoteService::class.java, *args)
}