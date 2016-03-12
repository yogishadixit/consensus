package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

import scala.collection.mutable.ListBuffer

/**
  * Created by yogishadixit on 3/11/16.
  */
case class Poll(id : Int,
                creatorId: Int,
                timestamp: Timestamp,
                userIds: ListBuffer[Int],
                suggestionIds: ListBuffer[Int],
                decisionId: Int) extends Activity
