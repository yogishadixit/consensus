package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

/**
  * Created by yogishadixit on 3/11/16.
  */
case class Suggestion(creator: User,
                      timestamp: Timestamp,
                      place: Place) extends Activity
