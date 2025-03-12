package aui.terminus.algebra

import terminus.Program
import terminus.Terminal
import aui.algebra.Algebra
import aui.algebra.Controls

given [A] => Conversion[Program[A], Terminal => A]:
  def apply(program: Program[A]): Terminal => A =
    terminal => {
      given Terminal = terminal
      program
    }

trait TerminusAlgebra extends Algebra {
  type Ui[A] = Tui[?, A]
}

