package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
case class Suggestion(creator: User,
                      timestamp: Timestamp,
                      name: String,
                      description: String,
                      location: String,
                      rating: Float,
                      yesVotes: ListBuffer[User],
                      noVotes: ListBuffer[User])
