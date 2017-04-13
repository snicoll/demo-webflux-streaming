package com.example.quote

import org.springframework.http.MediaType.APPLICATION_STREAM_JSON
import org.springframework.http.MediaType.TEXT_EVENT_STREAM
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import java.time.Duration.ofMillis

@Component
class QuoteHandler(val quoteGenerator: QuoteGenerator) {

    fun fetchQuotesSSE(req: ServerRequest) = ok()
            .contentType(TEXT_EVENT_STREAM)
            .body(quoteGenerator.fetchQuoteStream(ofMillis(200)), Quote::class.java)

    fun fetchQuotes(req: ServerRequest) = ok()
            .contentType(APPLICATION_STREAM_JSON)
            .body(quoteGenerator.fetchQuoteStream(ofMillis(200)), Quote::class.java)

}
