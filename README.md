# Web flux streaming demo

This demo application showcases some of the features of the reactive support in Spring
Framework 5.

`quote-service` is a functional-based kotlin service that emits a "random" quote every
200ms, either as server-sent events (SSE) or json stream.

`quote-app` uses embedded MongoDB and the upcoming reactive MongoDB support to showcase
how a template engine can integrate with this new paradigm. It also has a UI that uses
display the value of a set of actions live. For that, it uses the new `WebClient` API on
the server side to get the values from the `quote-service` in a reactive fashion.

To run the demo, simply start the two apps and go to `http://localhost:8080`.