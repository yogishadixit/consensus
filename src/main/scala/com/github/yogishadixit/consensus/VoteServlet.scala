package com.github.yogishadixit.consensus

import com.github.yogishadixit.consensus.models.Vote
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
class VoteServlet extends ConsensusStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  // before every action runs, set the content type to be JSON
  before () {
    contentType = formats("json")
  }

  get("/:suggId") {
    VoteData.votes.filter(_.suggestionId == params("suggId"))
  }

  post("/") {
    VoteData.votes += parsedBody.extract[Vote]
  }
}

object VoteData {
  val votes : ListBuffer[Vote] = new ListBuffer[Vote]()
}
