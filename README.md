# worker-demo

This app deploys as a worker tier app which is hard linked to an input from an SQS queue. Every message that is sent to the SQS queue is POSTed  to the worker, who receives the object and sends a new message to a second queue.

Currently, the message is received, appended with " it worked!", and forwarded to the second queue.






## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2014 FIXME
