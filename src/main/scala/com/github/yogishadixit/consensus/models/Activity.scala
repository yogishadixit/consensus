package com.github.yogishadixit.consensus.models

import java.sql.Timestamp

/**
  * Created by yogishadixit on 3/11/16.
  */
trait Activity {
  def timestamp : Timestamp
  def creator : User
}
