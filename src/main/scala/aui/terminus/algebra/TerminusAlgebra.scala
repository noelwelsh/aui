package aui.terminus.algebra

import terminus.Program
import terminus.Terminal
import aui.algebra.Algebra

given [A] => Conversion[Program[A], Terminal => A]:
  def apply(program: Program[A]): Terminal => A =
    terminal => {
      given Terminal = terminal
      program
    }

final case class Tui[S, A](
    height: Int,
    draw: Terminal => Unit,
    initialState: S,
    interact: S => Program[A]
)

trait TerminusAlgebra extends Algebra {
  type Ui[A] = Tui[?, A]
}
