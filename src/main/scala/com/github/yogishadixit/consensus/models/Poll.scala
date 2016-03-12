package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
case class Poll(creator: User,
                timestamp: Timestamp,
                users: ListBuffer[User],
                suggestions: ListBuffer[Suggestion],
                consensus: Suggestion) extends Activity
