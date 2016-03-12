package com.github.yogishadixit.consensus

import com.github.yogishadixit.consensus.models.Poll
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
class PollServlet extends ConsensusStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  // before every action runs, set the content type to be JSON
  before () {
    contentType = formats("json")
  }

  get("/:id") {
    PollData.polls.find(_.id == params("id"))
  }

  get("/") {
    PollData.polls.toList
  }

  post("/") {
    PollData.polls += parsedBody.extract[Poll]
  }
}

object PollData {
  val polls : ListBuffer[Poll] = new ListBuffer[Poll]()
}
