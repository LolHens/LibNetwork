package org.lolhens.network.actor

import java.nio.channels.{SelectableChannel, Selector}

import akka.actor.{ActorRef, Actor}
import org.lolhens.network.actor.SelectorActor._

/**
 * Created by LolHens on 10.07.2015.
 */
class SelectorActor extends Actor {
  var selector: Selector = _


  @throws[Exception](classOf[Exception])
  override def preStart(): Unit = selector = Selector.open()

  override def receive: Receive = {
    case Register(channel, ops, selectionHandler) =>
      channel.configureBlocking(false)

      channel.register(selector, ops) //KeyContainer

    case Select() =>
      selector.select(100)


    case _ =>
  }
}

object SelectorActor {
  case class Register(channel: SelectableChannel, ops: Int, selectionHandler: ActorRef)
  case class Select()
}