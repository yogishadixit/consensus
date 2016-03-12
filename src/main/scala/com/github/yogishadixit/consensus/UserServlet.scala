package com.github.yogishadixit.consensus

// JSON-related libraries
import com.github.yogishadixit.consensus.models.User
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ErrorHandler

// JSON handling support from Scalatra
import org.scalatra.json._

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
class UserServlet extends ConsensusStack with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  // before every action runs, set the content type to be JSON
  before () {
    contentType = formats("json")
  }

  // get by id endpoint
  get("/:id") {
    UserData.users.find(_.id == params("id"))
  }

  // get all endpoint
  get("/") {
    UserData.users.toList
  }

  // create user endpoint
  post("/") {
    UserData.users += parsedBody.extract[User]
  }

  override def error(handler: ErrorHandler): Unit = ???
}

object UserData {
  val users : ListBuffer[User] = new ListBuffer[User]()
}