package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

/**
  * Created by yogishadixit on 3/11/16.
  */
case class Vote(id : Int,
                creatorId: Int,
                timestamp: Timestamp,
                suggestionId: Int,
                vote : Boolean) extends Activity
