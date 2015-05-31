package org.lolhens.network

/**
 * Created by LolHens on 17.04.2015.
 */
trait Client[Packet] {
  def send(packet: Packet): Unit
}
