package com.github.yogishadixit.consensus

import org.scalatra._

class ConsensusServlet extends ConsensusStack {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }

  override def error(handler: ErrorHandler): Unit = ???
}
