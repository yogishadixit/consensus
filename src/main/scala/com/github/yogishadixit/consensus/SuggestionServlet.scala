package com.github.yogishadixit.consensus

import com.github.yogishadixit.consensus.models.Suggestion
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport

import scala.collection.mutable.ListBuffer
/**
  * Created by yogishadixit on 3/11/16.
  */
class SuggestionServlet extends ConsensusStack with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  // before every action runs, set the content type to be JSON
  before () {
    contentType = formats("json")
  }

  get("/:id") {
    SuggestionData.suggestions.find(_.id == params("id"))
  }

  get("/:pollId") {
    val suggestionIds : Option[ListBuffer[Int]] = PollData.polls.find(_.id == params("pollId")).map(_.suggestionIds)
    suggestionIds map { ids =>
      SuggestionData.suggestions filter { suggestion =>
        ids.contains(suggestion.id)
      }
    }
  }

  post("/:pollId") {
    PollData.polls.find(_.id == params("pollId")) map { poll =>
      val suggestion = parsedBody.extract[Suggestion]
      SuggestionData.suggestions += suggestion
      poll.suggestionIds += suggestion.id
    }
  }

}

object SuggestionData {
  val suggestions : ListBuffer[Suggestion] = new ListBuffer[Suggestion]()
}
