package aui.terminus.algebra

import terminus.*

final case class Tui[S, A](
    height: Int,
    draw: Terminal => Unit,
    initialState: S,
    interact: S => Program[A]
) {
  def create(): A =
    Terminal.run { terminal ?=>
      draw(terminal)
      interact(initialState)
    }
}
